package com.xiazhimiao.zipstream;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipStream {
    public static void main(String[] args) throws IOException {
        /*
         * 压缩文件夹
         * 文件夹内含有子文件夹
         * */
        //1.要压缩的文件夹
        File sourceFile = new File("E:\\个人主页");
        //2.源文件夹的父级
        File parentFile = sourceFile.getParentFile();
        //3.压缩的目的地
        File endFile = new File(parentFile, sourceFile.getName() + ".zip");
        //4.创建压缩流关联压缩包
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(endFile));

        long l1 = System.currentTimeMillis();

        //5.递归原文件夹，创建每个entry对象
        toZip(sourceFile, zos, sourceFile.getName());

        long l2 = System.currentTimeMillis()-l1;
        System.out.println(l2/1000.0);

        //6.关闭压缩流
        zos.close();
    }

    public static void toZip(File source, ZipOutputStream zos, String name) throws IOException {
        File[] files = source.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                //最难的一步，变成相对路径
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());
                zos.putNextEntry(entry);
                FileInputStream fis = new FileInputStream(file);

               /*
                    原文件夹7MB
                    如果没有缓冲区7.385s
                    如果自己创建缓冲区0.234s
                    int b;
                */
                byte[] bytes = new byte[1024];
                while ((fis.read(bytes))!=-1){
                    zos.write(bytes);
                }
                fis.close();
                zos.closeEntry();
            }else {
                toZip(file,zos,name+"\\"+file.getName());
            }
        }
    }
}
