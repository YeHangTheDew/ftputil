package com.yechh.server;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 11:22
 * @description：
 * @modified By：
 * @version: v1.0
 */

import com.yechh.domain.Ftp;
import com.yechh.ui.ConfigUI;
import com.yechh.util.sbutil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

public class Mainstart extends JFrame {
    public static Map<String,Ftp> ftpMap =new HashMap<>();


    // 定义组件
    JPanel jp1, jp2, jp3, jp4, jp5;
    JLabel jlb1, jlb2,jlb3,jlb4;
    JButton jb1, jb2;
    JTextField jtf1,jtf2,jtf3;
    JPasswordField jpf1;

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Mainstart d1 = new Mainstart();

    }

    // 构造函数
    public Mainstart() {

        jp1 = new JPanel();
        jp2 = new JPanel();
        jp3 = new JPanel();
        jp4 = new JPanel();
        jp5 = new JPanel();

        jlb1 = new JLabel("地址：");
        jlb2 = new JLabel("端口：");
        jlb3 = new JLabel("账号：");
        jlb4 = new JLabel("密码：");

        jb1 = new JButton("登录");
        jb2 = new JButton("重置");
        jb1.addActionListener(new LoginEventListener());


        jtf1 = new JTextField(10);
        jtf2 = new JTextField(10);
        jtf3 = new JTextField(10);

        jpf1 = new JPasswordField(10);// 设置布局管理(上面忘记：extends JFrame，这里出错了)
        this.setLayout(new GridLayout(4, 1));

        // 加入各个组件
        jp1.add(jlb1);
        jp1.add(jtf1);

        jp2.add(jlb2);
        jp2.add(jtf2);

        jp3.add(jlb3);
        jp3.add(jtf3);

        jp4.add(jlb4);
        jp4.add(jpf1);

        jp5.add(jb1);
        jp5.add(jb2);

        // 加入到JFrame
        this.add(jp1);
        this.add(jp2);
        this.add(jp3);
        this.add(jp4);
        this.add(jp5);

        this.setSize(350, 200);
        this.setTitle("ftp工具");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);



    }

    // 内部类LoginEventListener，实现ActionListener接口
    class LoginEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String addr=jtf1.getText();
            String user=jtf3.getText();
            String password=String.valueOf(jpf1.getPassword());
            String port=jtf2.getText();
            String ftpKey= sbutil.converString(addr,user,password,port);
            Ftp ftp=new Ftp(addr,user,password,Integer.valueOf(port));
            ftpMap.put(ftpKey,ftp);
            //关闭当前界面
            dispose();
            ConfigUI configUtil=new ConfigUI(ftpKey);
        }
    }

}
