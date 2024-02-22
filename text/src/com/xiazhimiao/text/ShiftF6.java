package com.xiazhimiao.text;

import java.util.Scanner;

public class ShiftF6 {
    public static void main(String[] args) {
        for (int i = 0; i < 6; i++) {
            for (int i1 = 0; i1 < 6; i1++) {
                //之前微软输入法不能使用一些快捷键，换成微信输入法就ok了

            }
        }
        fu fu1 = new fu();
        fu fu2 = new fu();
        for (int i : fu1.arr) {
            System.out.println(i);
        }
        fu2.arr[0]=10;
        for (int i : fu1.arr) {
            System.out.println(i);
        }
      /*  Scanner sc = new Scanner(System.in);
        sc.nextLine();*/
        //想要不同对象有相同数据，需要用到只加载一次的静态代码块
    }

}

class fu{
    int[] arr={1,2,3};
    static {
        int[] arr2={1,2,3};
    }
}
