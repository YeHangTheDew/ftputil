package com.yechh.server;

import com.yechh.constant.JarMap;
import com.yechh.constant.configMap;
import com.yechh.domain.Ftp;
import com.yechh.factory.Ftpfactory;
import com.yechh.util.FtpJSch;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Map;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/29 15:32
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class SimpleServer extends JFrame {

    private static Map configMap=new configMap();
    private static Map JarMap=new JarMap();
    private String sigleJar="";
    private String[] configArry=null;
    private JDialog tipDialog;
    private JLabel lab;
    public static void main(String[] args){
        SimpleServer server=new SimpleServer();

    }
    public SimpleServer(){
        configArry=(configMap.get("172.16.0.125_root_xwaPaaS@2017._22").toString()+","+configMap.get("172.16.0.139_root_xwaPaaS@2017._22").toString()).split(",");
        JPanel chosePanel=new JPanel();
        JPanel allJpanel=new JPanel();
        JPanel siglePanel=new JPanel();

        tipDialog = new JDialog(this, "执行情况", true);//弹出的对话框
        tipDialog.setBounds(400, 200, 350, 250);//设置弹出对话框的位置和大小
        tipDialog.setLayout(new FlowLayout());//设置弹出对话框的布局为流式布局
        lab = new JLabel();//创建lab标签填写提示内容
        JButton okBut = new JButton("确定");//创建确定按钮
        // 确定按钮监听器
        okBut.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                tipDialog.setVisible(false);
            }

        });
        tipDialog.add(lab);
        tipDialog.add(okBut);


        JButton jButton=new JButton("全部推送重启");
        JButton sigleButton=new JButton("单个推送重启");
        JLabel choseJLbel=new JLabel("请选择的服务");
        JComboBox choseBox=new JComboBox(configArry);
        //设置下拉框默认值
        choseBox.setSelectedItem(configArry[0]);
        sigleJar=configArry[0];
        choseBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                sigleJar= e.getItem().toString();
            }
        });
        jButton.addActionListener(new AllpublishEventListener());
        sigleButton.addActionListener(new PublishSigleEventListener());

        chosePanel.add(choseJLbel);
        chosePanel.add(choseBox);
        this.add(chosePanel);
        allJpanel.add(jButton);
        siglePanel.add(sigleButton);
        this.add(allJpanel);
        this.add(siglePanel);
        this.setBounds(400,200,350,200);
        this.setLayout(new GridLayout(4, 1));
        this.setSize(350, 200);
        this.setTitle("ftp工具");
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }
    class AllpublishEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String result="";
            if(configArry==null){
                System.out.println("执行的jar为空");
            }
            for(int i=0;i<configArry.length;i++){
                result+=publish(JarMap.get(configArry[i]).toString(),configArry[i]);
            }

            lab.setText("推送重启成功");
            tipDialog.setVisible(true);

        }
    }
    class PublishSigleEventListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String config=JarMap.get(sigleJar).toString();
            String result=publish(config,sigleJar);
            lab.setText("推送重启成功");
            tipDialog.setVisible(true);

        }
    }
    /**
     * create by: yechh
     * description: 推送到ftp并重启脚本
     * create time: 2019/4/30 10:21
     * @return
     */
    public String publish(String config,String sigleJar){
        String result="";
        String[] configArray=config.split(",");
        Ftp ftp= Ftpfactory.getFtp(configArray[3]);
        FtpJSch jSch=FtpJSch.getConnect(ftp);
        result+=jSch.upload(configArray[0],configArray[1],sigleJar);
        result+=jSch.exec(configArray[2]);
        System.out.println(result);
        jSch.disconnect();
        return result;
    }




}
