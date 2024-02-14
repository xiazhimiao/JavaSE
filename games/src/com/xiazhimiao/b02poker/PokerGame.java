package com.xiazhimiao.b02poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.TreeSet;

public class PokerGame {
    //定义一个HashMap用来存储牌和序号
    static HashMap<Integer, String> hm = new HashMap<>();

    //定义一个ArrayList存储序号，之后操作的都是序号，利用序号找牌
    static ArrayList<Integer> list = new ArrayList<>();

    static {
        //准备牌
        String[] color = {"⬛️", "♣️", "♥️", "♠️" };
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A", "2" };
        //装牌和牌的序号
        int serialNumber = 1;
        //细节：外层数字，内层花色。
        //一下子把每个数字不同花色遍历在一起
        for (String j : number) {
            for (String s : color) {
                hm.put(serialNumber, s + j);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        hm.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber++;
        hm.put(serialNumber, "大王");
        list.add(serialNumber);
    }

    public PokerGame() {
        //第一步：洗牌，其实是洗牌的序号
        Collections.shuffle(list);

        //第二步：发牌
        //创建四个集合，这里使用TreeSet集合，底层默认int排序
        TreeSet<Integer> lord = new TreeSet<>();
        TreeSet<Integer> player1 = new TreeSet<>();
        TreeSet<Integer> player2 = new TreeSet<>();
        TreeSet<Integer> player3 = new TreeSet<>();

        for (int i = 0; i < list.size(); i++) {
            //i依次表示集合中的每一个索引
            //list.get(i)得到牌的序号
            Integer serialNumber = list.get(i);
            if (i <= 2) {
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0) {
                player1.add(serialNumber);
            } else if (i % 3 == 1) {
                player2.add(serialNumber);
            } else {
                player3.add(serialNumber);
            }
        }

        //第三步：看牌
        lookPoker("地主牌",lord);
        lookPoker("张三",player1);
        lookPoker("李四",player2);
        lookPoker("王五",player3);
    }

    private void lookPoker(String name,TreeSet<Integer> ts) {
        System.out.print(name+":");
        for (Integer serialNumber : ts) {
            System.out.print(hm.get(serialNumber) + " ");
        }
        System.out.println();
    }
}
