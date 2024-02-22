package com.xiazhimiao.myiotext1;

import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Text2 {
    public static void main(String[] args) throws IOException {
        //数据爬取
        //URL url = new URL("https://yzzy1.play-cdn20.com/20240211/16742_01582699/2000k/hls/index.m3u8");
        //String s = webCrawler(url);
        //数据写入本地
        //IOUtils.write(s, new FileOutputStream("myiotext\\b.txt"));

        //
        URL url = new URL("https://yzzy1.play-cdn20.com/20240211/16742_01582699/2000k/hls/"+"4645fa64836000000.ts");
        String s = webCrawler(url);
        //数据写入本地
        IOUtils.write(s, new FileOutputStream("myiotext\\ts0\\ts0000.ts"));
    }

    private static String webCrawler(URL url) throws IOException {
        URLConnection opened = url.openConnection();
        StringBuilder sb = new StringBuilder();
        //利用方法建立字节输入流
        InputStream inputStream = opened.getInputStream();
        //利用转换流，转换为字符流
        InputStreamReader isr = new InputStreamReader(inputStream);
        //读取数据
        int ch;
        while ((ch = isr.read()) != -1) {
            sb.append((char) ch);
        }
        isr.close();
        return sb.toString();
    }
}
