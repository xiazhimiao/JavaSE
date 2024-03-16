package com.xiazhimiao.a0316;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class StudentFrame extends JFrame implements ActionListener {
    JTextArea showArea;
    JTextField inputName, inputScore;
    JButton button;
    TreeSet<Student> treeSet;

    StudentFrame() {
        //treeSet= 【代码1】 //使用无参数构造方法创建treeSet

        treeSet = new TreeSet<>(); // 创建一个TreeSet对象，用于存储数据
        showArea = new JTextArea(); // 创建一个JTextArea对象，用于显示文本
        showArea.setFont(new Font("", Font.BOLD, 20)); // 设置showArea的字体为粗体，大小为20
        inputName = new JTextField(5); // 创建一个JTextField对象，用于输入姓名，宽度为5个字符
        inputScore = new JTextField(5); // 创建一个JTextField对象，用于输入分数，宽度为5个字符
        button = new JButton("确定"); // 创建一个JButton对象，文本为"确定"
        button.addActionListener(this); // 为button添加一个ActionListener，用于监听按钮点击事件
        JPanel pNorth = new JPanel(); // 创建一个JPanel对象，用于放置输入框和按钮
        pNorth.add(new JLabel("Name:")); // 在pNorth中添加一个JLabel对象，文本为"Name:"
        pNorth.add(inputName); // 在pNorth中添加inputName对象
        pNorth.add(new JLabel("Score:")); // 在pNorth中添加一个JLabel对象，文本为"Score:"
        pNorth.add(inputScore); // 在pNorth中添加inputScore对象
        pNorth.add(button); // 在pNorth中添加button对象
        add(pNorth, BorderLayout.NORTH); // 将pNorth添加到窗口的北部
        add(showArea, BorderLayout.CENTER); // 将showArea添加到窗口的中部
        setSize(300, 320); // 设置窗口的大小为300x320
        setVisible(true); // 设置窗口可见
        validate(); // 验证窗口的布局
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 设置窗口关闭时的操作为退出程序

    }

    public void actionPerformed(ActionEvent e) {
        String name = inputName.getText();
        int score = 0;
        try {
            score = Integer.parseInt(inputScore.getText().trim());
            if (name.length() > 0) {
                Student stu = new Student(name, score);
              //【代码2】 // treeSet添加stu
                treeSet.add(stu);
                show(treeSet);
            }
        } catch (NumberFormatException exp) {
            inputScore.setText("请输入数字字符");
        }
    }

    public void show(TreeSet tree) {
        showArea.setText(null);
        Iterator<Student> te = treeSet.iterator();
        while (te.hasNext()) {
            Student stu = te.next();// te返回其中的下一个元素
            showArea.append("Name:" + stu.getName() + " Score: " + stu.getScore() + "\n");
        }
    }

}
