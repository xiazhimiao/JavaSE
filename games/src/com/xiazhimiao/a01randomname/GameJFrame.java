package com.xiazhimiao.a01randomname;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameJFrame extends JFrame implements ActionListener {

    JButton start = new JButton("开始");
    JLabel countDown = new JLabel("倒计时：5秒");
    int seconds = 5; // 倒计时的秒数
    ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();


    public GameJFrame() {


        //设置界面
        initJframe();

        //添加组件
        initView();

        //界面显示出来
        this.setVisible(true);

    }

    //添加组件
    public void initView() {

        countDown.setFont(new Font(null,1,50));
        countDown.setBounds(50,50,300,60);
        this.getContentPane().add(countDown);


        JLabel namePrompt = new JLabel("中奖选手为：");
        namePrompt.setFont(new Font(null,1,20));
        namePrompt.setBounds(80,150,125,30);
        this.getContentPane().add(namePrompt);

        JLabel rollName = new JLabel("XXX");
        rollName.setFont(new Font(null,1,20));
        rollName.setBounds(200,150,125,30);
        this.getContentPane().add(rollName);

        JLabel rollImage = new JLabel(new ImageIcon("默认图片路径"));
        rollImage.setBounds(87,200,210,210);
        this.getContentPane().add(rollImage);

        start.setFont(new Font(null,1,20));
        start.setBounds(118,430,150,50);
        start.setBackground(Color.WHITE);
        //添加点击事件
        start.addActionListener(this);
        this.getContentPane().add(start);

    }


    //设置界面
    public void initJframe() {
        //设置标题
        this.setTitle("随机点名器");
        //设置大小
        this.setSize(400, 600);
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

    Runnable task = new Runnable() {
        int remainingSeconds = seconds;

        public void run() {
            if (remainingSeconds > 0) {
                countDown.setText("倒计时："+remainingSeconds +"秒");
                remainingSeconds--;
            } else {
                System.out.println("倒计时结束");
                //remainingSeconds=5;
                executor.shutdown(); // 倒计时结束后关闭执行器
            }
        }
    };
    @Override
    public void actionPerformed(ActionEvent e) {
        Object o = e.getSource();
        if(o == start){

         /*   证明拿到了之前存的不抽到的人名
               System.out.println(10);
            for (String s : CheatJFrame.arrayList) {
                System.out.println(s);
            }*/
            executor.scheduleAtFixedRate(task, 0, 1, TimeUnit.SECONDS); // 每秒执行一次任务
        }

    }

}
