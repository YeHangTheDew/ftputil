package com.yechh.ui;

import com.opslab.util.PropertiesUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 14:12
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class ConfigUI extends JFrame{
    private String ftpKey;
    private JPanel configJpanel,addJpanel,publishJpanel;
    private JTextField configField;
    private JButton addButton,publishJbutton;

    public ConfigUI(String ftpKey){
        this.ftpKey=ftpKey;
        //File file=new File("congfig.properties");
        String config=PropertiesUtil.GetValueByKey("congfig.properties",ftpKey);
        configJpanel=new JPanel();
        addJpanel=new JPanel();
        publishJpanel=new JPanel();
        configField=new JTextField(config);
        addButton=new JButton("配置");
        addButton.addActionListener(new AddActinListener());
        publishJbutton=new JButton("推送");
        publishJbutton.addActionListener(new PublishActinListener());
        configJpanel.add(configField);
        addJpanel.add(addButton);
        publishJpanel.add(publishJbutton);
        this.setLayout(new GridLayout(3, 1));
        this.add(configJpanel);
        this.add(addJpanel);
        this.add(publishJpanel);
        this.setSize(350, 200);
        this.setTitle("配置环境");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    // 内部类LoginEventListener，实现ActionListener接口
    class PublishActinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    }

    // 内部类LoginEventListener，实现ActionListener接口
    class AddActinListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {

            //关闭当前界面
            dispose();

        }
    }


}
