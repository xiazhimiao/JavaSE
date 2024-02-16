package com.xiazhimiao.numberFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class DataOperation {
    public static void main(String[] args) {
        ArrayList<String> list =new ArrayList<>();
        Collections.addAll(list,"张三,23","lisi,24","王五,25");
        Map<String, Integer> map = list.stream().filter(age -> Integer.parseInt(age.split(",")[1]) >= 24)
                .collect(Collectors.toMap(name -> name.split(",")[0], age -> Integer.parseInt(age.split(",")[1])));
        System.out.println(map);
    }

}
