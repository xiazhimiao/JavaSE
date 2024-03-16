package com.xiazhimiao.a0316;

public class Student implements Comparable {
    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public int compareTo(Object b) {
        Student st = (Student) b;
        int m = this.score - st.score;
        //进一步判断name和score，确定不重复
        if (this.name.equals(st.name)) {
            return m;
        }
        //这个判断不能简化
        if (m != 0)
            return m;
        else
            return 1;
    }

    public int getScore() {
        return score;
    }

    public String getName() {
        return name;
    }
}