package com.yechh.server;

import com.yechh.domain.Ftp;
import com.yechh.util.FtpJSch;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 9:45
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class Start {

    public static void  main(String[] args){
        try {
           /* Ftp ftp=new Ftp("172.16.0.125","root","xwaPaaS@2017.",22);
            FtpJSch ftpJSch=FtpJSch.getConnect(ftp);
            ftpJSch.upload("F:\\IdeaProjects\\K00MasterService\\xtion-rest-master\\build\\libs\\xtion-rest-master-0.1.0.jar","/home/apaas/master-service","xtion-rest-master-0.1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\OperateLog\\xw-log-rest\\build\\libs\\xw-log-rest-0.1.0.jar","/home/apaas/log-rest","xw-log-rest-0.1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\BizEngine-Service\\etl-bizengine\\build\\libs\\etl-bizengine-1.0.0.jar","/home/apaas/etl-bizengine","etl-bizengine-1.0.0.jar");

            FtpJSch.disconnect();

            Ftp ftprest=new Ftp("172.16.0.139","root","xwaPaaS@2017.",22);
            ftpJSch=FtpJSch.getConnect(ftprest);
            ftpJSch.upload("F:\\IdeaProjects\\XtionMessage\\xw-message-rest\\build\\libs\\xw-message-rest-0.1.0.jar","/home/apaas/message-rest","xw-message-rest-0.1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\AuthorizationEngine-Service\\xw-role-permission-rest\\build\\libs\\xw-role-permission-rest-0.1.0.jar","/home/apaas/role-permission-rest","xw-role-permission-rest-0.1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\ReportEngine\\biengine\\build\\libs\\biengine-0.1.0.jar","/home/apaas/biengine","biengine-0.1.0.jar");
            */
            Ftp ftprest=new Ftp("172.16.0.125","root","xwaPaaS@2017.",22);
            FtpJSch ftpJSch=FtpJSch.getConnect(ftprest);///home/apaas/uiprotocol-rest
            //ftpJSch.upload("F:\\IdeaProjects\\Ui-Protocol-Service\\xw-uiprotocol-rest\\build\\libs\\xw-uiprotocol-rest-0.1.0.jar","/home/apaas/master-service","xw-uiprotocol-rest-0.1.0.jar");
            String command="cd /home/apaas/master-service;./masterservice.py restart";
            System.out.println(ftpJSch.exec(command));
            /* ftpJSch.upload("F:\\IdeaProjects\\WorkflowEngine-Service\\xw-flowengine-rest\\build\\libs\\xw-flowengine-rest-1.0.jar","/home/apaas/flowengine-rest","xw-flowengine-rest-1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\ResourceConfig-Service\\xw-resourceconfig\\build\\libs\\xw-resourceconfig-service-0.1.0.jar","/home/apaas/resourceconfig-service","xw-resourceconfig-service-0.1.0.jar");
            ftpJSch.upload("F:\\IdeaProjects\\AccountService\\xw-account-rest\\build\\libs\\xw-account-rest-0.1.0.jar","/home/apaas/account-rest","xw-account-rest-0.1.0.jar");
            */
            Thread.sleep(5000);
            ftpJSch.disconnect();
            System.out.println("上传文件完成。。。。");
        }catch (Exception e){
            System.out.println("出现异常："+e.getMessage()+"具体情况为："+e.toString());

        }



    }
}
