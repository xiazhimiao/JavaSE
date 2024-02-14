package com.xiazhimiao.b03poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class PokerGame {
    //牌库
    static ArrayList<String> list = new ArrayList<>();
    //牌的价值
    static HashMap<String, Integer> hm = new HashMap<>();

    static {
        //准备牌
        //这里的花色不是一个字符♥️,所以在下面利用subString分割时会出错。
        //而且因为”不可见“，不容易找出错误
        //char c = '♣';
        //char c ="♣\uFE0F"
        //char c = "\\uFE0F";
        //String[] color = {"⬛️", "♣️", "♥️", "♠️" };
        String[] color = {"♦", "♣", "♥", "♠" };
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        //装牌
        for (String j : number) {
            for (String s : color) {
                list.add(s + j);
            }
        }
        list.add(" 小王");
        list.add(" 大王");
        //牌的价值添加
        hm.put("J", 11);
        hm.put("Q", 12);
        hm.put("K", 13);
        hm.put("A", 14);
        hm.put("2", 15);
        hm.put("小王", 50);
        hm.put("大王", 100);
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        //遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if (i <= 2) {
                lord.add(poker);
                continue;
            }
            //给三个玩家轮流发牌
            if (i % 3 == 0) {
                player1.add(poker);
            } else if (i % 3 == 1) {
                player2.add(poker);
            } else {
                player3.add(poker);
            }
        }
        //排序
        order(lord);
        order(player1);
        order(player2);
        order(player3);
        //看牌
        lookPoker("地主", lord);
        lookPoker("张三", player1);
        lookPoker("李四", player2);
        lookPoker("王五", player3);
    }

    private void order(ArrayList<String> list) {
        Collections.sort(list, new Comparator<String>() {
            //底层Arrays.sort，插入排序+二分查找（数组）
            @Override
            public int compare(String o1, String o2) {
                //o1：无序中的牌，也是要查的数
                //o2：有序中的牌
                //小：前面，大：后面，0：根据花色
                //获取花色and值
                String color1 = o1.substring(0, 1);
                int value1 = getValue(o1);
                //复制粘贴固然好用，但不可大意
                String color2 = o2.substring(0, 1);
                int value2 = getValue(o2);

                int i = value1 - value2;
                //System.out.print(i);打印出来检查到了错误
                return i == 0 ? color1.compareTo(color2) : i;
            }
        });
    }

    private int getValue(String poker) {
        //获取值
        String number = poker.substring(1);
        if (hm.containsKey(number)) {
            return hm.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }

    public void lookPoker(String name, ArrayList<String> list) {
        System.out.print(name + ":");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
