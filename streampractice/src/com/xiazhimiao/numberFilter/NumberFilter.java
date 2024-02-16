package com.xiazhimiao.numberFilter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NumberFilter {
    public static void main(String[] args) {
        //过滤奇数
        ArrayList<Integer> list1 = new ArrayList<>();
        Collections.addAll(list1,1,2,3,4,5,6,7,8,9,10);

 /*       List<Integer> list2 = list1.stream().filter(new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer % 2 == 0;
            }
        }).collect(Collectors.toList());   */

        List<Integer> list2 = list1.stream().filter(integer ->integer % 2 == 0).toList();


        //list2.forEach(a->System.out.println(a));
        //方法引用
        list2.forEach(System.out::println);
    }
}
