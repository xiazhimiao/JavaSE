package com.xiazhimiao.exception;

public class MyException {
    public static void main(String[] args) {
        //测试try
        int[] arr=new int[5];
        //try中遇到错误就跳出
        try {
            arr[0]=1;
            System.out.println(2/0);
        } catch (NullPointerException e) {
            System.out.println("kong");
        }catch (ArithmeticException e){
            System.out.println("suan");
        }

    }
}
