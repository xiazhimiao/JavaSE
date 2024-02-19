package com.xiazhimiao.text;

public class Text1 {
    public static void main(String[] args) {
        //详解UTF存储。以及char存储汉字
        char a = '夏';
        //utf序号：22799
        //二进制：0101 1001 0000 1111
        String binary = Integer.toBinaryString(a);
        System.out.println(binary);
        //01011001   00001111
        //0101 100100 001111

        byte[] bytes = "夏".getBytes();
        for (byte b : bytes) {
            System.out.println(b);
        }
        //-27 ,- 92 ,- 113

        //这个就是编码之后的utf码，也就是计算机存储的，打印的时候会将其转换为原码计算
        //1110-0101   10-100100 10-001111
        //11100101   10100100   10001111       计算机存储的是补码
        //10011010   11011011   11110000        反码
        //10011011（-27）   11011100（- 92）   11110001（- 113）        原码

        //1110xxxx 10xxxxxx 10xxxxxx utf-8汉字编码规范


    }
}
