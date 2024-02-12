package com.xiazhimiao.a01randomname;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;


public class CheatJFrame extends JFrame implements ActionListener, FocusListener {


    JButton submit = new JButton("确定");

    //创建一个文本框
    JTextField noRollName = new JTextField();//不会被点到的人
    //细节:成员位置只能进行定义，不能进行方法调用
    //noRollName.setText("张三," + "李四," + "王五," + "老六," + "钱七");

    JTextField count = new JTextField();//保底作弊次数
    JTextField rollName = new JTextField();//保底人
    //创建静态集合
    static ArrayList<String> arrayList = new ArrayList<>();


    public CheatJFrame() {
        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();
        if (obj == submit) {
            //定义输入正误判断变量
            boolean b = true;

            //创建正则表达式，定义输入框只能输入{1，2，3}其一
            //Pattern regex = Pattern.compile("[123]");
            //boolean isMatch = Pattern.matches(String.valueOf(regex), o.getText());
            boolean isMatch = Pattern.matches("[1-9]\\d{0,}", count.getText());
            if (isMatch) {
                System.out.println("输入符合要求");
            } else {
                System.out.println("输入不符合要求");
                b = false;
                JOptionPane.showMessageDialog(count, "类型输入错误，只能是>0的数字次数", "错误提示", JOptionPane.ERROR_MESSAGE);
            }

            //rollName只能是一个名字
            String strRollName = rollName.getText();
            for (int i = 0; i < strRollName.length(); i++) {
                char c = strRollName.charAt(i);
                if (c == ',' || c == '，') {
                    b = false;
                    JOptionPane.showMessageDialog(count, "只能输入一位同学", "错误提示", JOptionPane.ERROR_MESSAGE);
                }
            }

            //判断信息是否都符合要求
            if(b){
                //当数据都正常才执行添加操作
                //成员位置创建静态String[]数组，用来存储不会被点到的人
                String strNoRollName = noRollName.getText();
                String[] arr = strNoRollName.split(",|，");
                arrayList.addAll(Arrays.asList(arr));
                for (String s : arrayList) {
                    System.out.println(s);
                }

                this.setVisible(false);
                new GameJFrame();
            }


        }
    }

    //添加组件
    public void initView() {
        JLabel cheat = new JLabel("作弊时刻");
        cheat.setFont(new Font(null, 1, 30));
        cheat.setBounds(130, 10, 130, 30);
        this.getContentPane().add(cheat);

        JLabel hint1 = new JLabel("不会被点到的人");
        hint1.setFont(new Font(null, 0, 20));
        hint1.setBounds(30, 100, 140, 30);
        this.getContentPane().add(hint1);

        noRollName.setText("张三，李四，王五");
        noRollName.setBounds(180, 100, 140, 30);
        this.getContentPane().add(noRollName);

        JLabel hint2 = new JLabel("第");
        hint2.setFont(new Font(null, 0, 20));
        hint2.setBounds(30, 200, 30, 30);
        this.getContentPane().add(hint2);

        count.setBounds(60, 200, 30, 30);
        this.getContentPane().add(count);
        //添加焦点事件
        count.addFocusListener(this);

        JLabel hint3 = new JLabel("次,一定会被点到的人是：");
        hint3.setFont(new Font(null, 0, 20));
        hint3.setBounds(100, 200, 230, 30);
        this.getContentPane().add(hint3);

        rollName.setBounds(210, 240, 100, 30);
        this.getContentPane().add(rollName);


        submit.setFont(new Font(null, 1, 20));
        submit.setBounds(110, 300, 150, 50);
        submit.setBackground(Color.WHITE);
        submit.addActionListener(this);
        this.getContentPane().add(submit);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 500);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //取消内部默认居中放置
        this.setLayout(null);
        //设置背景颜色
        this.getContentPane().setBackground(Color.white);
        this.setAlwaysOnTop(true);//置顶
    }


    @Override
    public void focusGained(FocusEvent e) {
        //获得焦点
    }

    @Override
    public void focusLost(FocusEvent e) {
        //失去焦点
        JTextField o = (JTextField) e.getSource();
        //Object o = e.getSource();
        if (o == count) {
        /*    try {
                int i = Integer.parseInt(o.getText());

            }catch (NumberFormatException nfe){
                System.out.println("类型输入错误");
                JOptionPane.showMessageDialog(count, "类型输入错误，只能{1，2，3}其一", "错误提示", JOptionPane.ERROR_MESSAGE);
            }*/
            //创建正则表达式，定义输入框只能输入{1，2，3}其一
            //Pattern regex = Pattern.compile("[123]");
            //boolean isMatch = Pattern.matches(String.valueOf(regex), o.getText());
            boolean isMatch = Pattern.matches("[1-9]\\d{0,}", o.getText());
            if (isMatch) {
                System.out.println("输入符合要求");
            } else {
                System.out.println("输入不符合要求");
                JOptionPane.showMessageDialog(count, "类型输入错误，只能是数字次数", "错误提示", JOptionPane.ERROR_MESSAGE);
            }

        }

    }
}
