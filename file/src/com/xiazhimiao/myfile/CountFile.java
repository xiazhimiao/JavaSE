package com.xiazhimiao.myfile;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class CountFile {
    public static void main(String[] args) {

        //统计一个路径下面不同的后缀出现的次数
        File file = new File("E:\\");
        System.out.println(getCount(file));
    }
    public static HashMap<String,Integer> getCount(File file){
        //创建一个HashMap集合存储
        HashMap<String,Integer> hm = new HashMap<>();
        //拿到路径数组
        File[] files = file.listFiles();
        //如果拿不到为null，直接返回一个空的HashMap集合
        if(files == null){
            return hm;
        }
        //遍历
        for (File f : files) {
            if (f.isFile()) {
                String[] split = f.getName().split("\\.");
                String s = split[split.length - 1];
                if (hm.containsKey(s )){
                    Integer count = hm.get(s);
                    count++;
                    hm.put(s,count);
                }else {
                    hm.put(s,1);
                }
            } else {
                //如果是文件夹，递归
                HashMap<String, Integer> hm2 = getCount(f);
                for (Map.Entry<String, Integer> entry : hm2.entrySet()) {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    if(hm.containsKey(key)){
                        Integer count = hm.get(key);
                        hm.put(key,count+value);
                    }else {
                        hm.put(key,value);
                    }
                }
            }
        }
        return hm;
    }

}
