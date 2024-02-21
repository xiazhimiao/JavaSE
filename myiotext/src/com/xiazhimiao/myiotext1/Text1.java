package com.xiazhimiao.myiotext1;

import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Text1 {
    public static void main(String[] args) throws IOException {
        //链接
        URL url = new URL("https://baike.baidu.com/item/%E7%99%BE%E5%AE%B6%E5%A7%93/194637");
        String familyNameStr = webCrawler(url);

        //数据处理

        //创建正则表达式对象
       /*
        "_blank">令狐</a>
        ?<=:后顾匹配
        ？=:前瞻匹配
        ?:  :非捕获分组
        */
        //这里的正则都获取到了，不过多了一些其他的，可以用集合截取的方式
        ArrayList<String> familyNameStrTempList = gerData(familyNameStr, "(?<=\"_blank\">).{1,2}(?=</a>)");

        //利用IOUtils-io把数据写到本地
        IOUtils.write(familyNameStrTempList.toString(), new FileOutputStream("myiotext\\a.txt",true));

        //ArrayList好像没有截取方法，只有删除方法(受保护的，不让用)，Collections也没有

        //数组没找到返回下标的方法，利用集合先获取
        int i = familyNameStrTempList.indexOf("赵");
        int i1 = familyNameStrTempList.indexOf("福");

        String[] familyNameStrTempArr1 = familyNameStrTempList.toArray(new String[familyNameStrTempList.size()]);

        String[] familyNameStrTempArr2 = Arrays.copyOfRange(familyNameStrTempArr1, i, i1 + 1);
     /*
        遍历查看数据无误
       for (String s : familyNameStrTempArr2) {
            System.out.print(s+" ");
        }
        */
        FileOutputStream fos = new FileOutputStream("myiotext\\a.txt",true);
        fos.write('\n');
        for (String s : familyNameStrTempArr2) {
            fos.write(s.getBytes());
            fos.write(' ');
        }
        fos.close();

    }

    private static ArrayList<String> gerData(String familyNameStr, String regex) {
        //创建一个list集合存储
        ArrayList<String> list = new ArrayList<>();
        Pattern re = Pattern.compile(regex);
        Matcher matcher = re.matcher(familyNameStr);
        while (matcher.find()) {
            list.add(matcher.group());
        }
        return list;
    }

    /*
     * 获取源代码
     * */
    private static String webCrawler(URL url) throws IOException {
        //建立
        StringBuilder sb = new StringBuilder();
        //连接
        URLConnection urlConnection = url.openConnection();
        //利用方法建立字节输入流
        InputStream inputStream = urlConnection.getInputStream();
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
