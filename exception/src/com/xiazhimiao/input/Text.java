package com.xiazhimiao.input;

import com.xiazhimiao.customexception.AgeOutOfBoundsException;
import com.xiazhimiao.customexception.NameFormatException;

import java.util.Scanner;

public class Text {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend();
        Scanner sc = new Scanner(System.in);


        while (true) {
            try {
                System.out.println("请输入女朋友姓名");
                String name = sc.nextLine();
                girlFriend.setName(name);

                System.out.println("请输入女朋友年龄");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                girlFriend.setAge(age);
                break;
            } catch (NumberFormatException e) {
                System.out.println("年龄请输入数字");
            } catch (NameFormatException | AgeOutOfBoundsException e) {
                e.printStackTrace();
            }


        }
        System.out.println(girlFriend);

    }
}
