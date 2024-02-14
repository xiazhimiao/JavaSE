package com.xiazhimiao.b01poker;

import java.util.ArrayList;
import java.util.Collections;

public class PokerGame {
    //需要一个静态集合，用来存储所有牌
    //牌盒
    static ArrayList<String> list = new ArrayList<>();

    //静态代码快
    //特点：随着类的加载而加载，而且只执行一次
    static {
        //准备牌
        //"⬛️"，“♣️”，“♥️”，“♠️”
        //“3”，“4”，“5”，“6”，“7”，“8”，“9”，“10”，“J”,"Q","K","A","2"
        String[] color = {"⬛️","♣️","♥️","♠️"};
        String[] number = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};

        //装牌
        for (String s : color) {
            for (String j : number) {
                list.add(s + j);
            }
        }
        list.add("小王");
        list.add("大王");
    }

    public PokerGame() {
        //洗牌
        Collections.shuffle(list);
        //System.out.println(list);

        //发牌
        ArrayList<String> lord = new ArrayList<>();
        ArrayList<String> player1 = new ArrayList<>();
        ArrayList<String> player2 = new ArrayList<>();
        ArrayList<String> player3 = new ArrayList<>();

        //遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            if(i<=2){
                lord.add(poker);
                continue;
            }
            //给三个玩家轮流发牌
            if(i%3 == 0){
                player1.add(poker);
            }else if(i%3 == 1){
                player2.add(poker);
            }else {
                player3.add(poker);
            }
        }
        lookPoker("地主",lord);
        lookPoker("张三",player1);
        lookPoker("李四",player2);
        lookPoker("王五",player3);

        //看牌
    }
    public void lookPoker(String name,ArrayList<String> list){
        System.out.print(name + ":");
        for (String poker : list) {
            System.out.print(poker + " ");
        }
        System.out.println();
    }
}
