package com.yechh.constant;

import java.util.HashMap;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/29 15:02
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class JarMap extends HashMap<String,String> {
    public JarMap(){
        this.put("xtion-rest-master-0.1.0.jar","F:\\IdeaProjects\\K00MasterService\\xtion-rest-master\\build\\libs\\xtion-rest-master-0.1.0.jar,/home/apaas/master-service,cd /home/apaas/master-service;./masterservice.py restart,2");
        this.put("xw-log-rest-0.1.0.jar","F:\\IdeaProjects\\OperateLog\\xw-log-rest\\build\\libs\\xw-log-rest-0.1.0.jar,/home/apaas/log-rest,cd /home/apaas/log-rest;./logeserver.py restart,2");
        this.put("etl-bizengine-1.0.0.jar","F:\\IdeaProjects\\BizEngine-Service\\etl-bizengine\\build\\libs\\etl-bizengine-1.0.0.jar,/home/apaas/etl-bizengine,cd /home/apaas/etl-bizengine;./etlbizengineserver.py restart,2");
        this.put("xw-message-rest-0.1.0.jar","F:\\IdeaProjects\\XtionMessage\\xw-message-rest\\build\\libs\\xw-message-rest-0.1.0.jar,/home/apaas/message-rest,cd /home/apaas/message-rest;./messageserver.py,1");
        this.put("xw-role-permission-rest-0.1.0.jar","F:\\IdeaProjects\\AuthorizationEngine-Service\\xw-role-permission-rest\\build\\libs\\xw-role-permission-rest-0.1.0.jar,/home/apaas/role-permission-rest,cd /home/apaas/role-permission-rest;./rolepermissionserver.py restart,1");
        this.put("biengine-0.1.0.jar","F:\\IdeaProjects\\ReportEngine\\biengine\\build\\libs\\biengine-0.1.0.jar,/home/apaas/biengine,cd /home/apaas/biengine;./biengineserver.py restart,1");
        this.put("xw-flowengine-rest-1.0.jar","F:\\IdeaProjects\\WorkflowEngine-Service\\xw-flowengine-rest\\build\\libs\\xw-flowengine-rest-1.0.jar,/home/apaas/flowengine-rest,cd /home/apaas/flowengine-rest;./flowengineserver.py restart,1");
        this.put("xw-resourceconfig-service-0.1.0.jar","F:\\IdeaProjects\\ResourceConfig-Service\\xw-resourceconfig\\build\\libs\\xw-resourceconfig-service-0.1.0.jar,/home/apaas/resourceconfig-service,cd /home/apaas/resourceconfig-service;./resourceconfigserver.py restart,1");
        this.put("xw-account-rest-0.1.0.jar","F:\\IdeaProjects\\AccountService\\xw-account-rest\\build\\libs\\xw-account-rest-0.1.0.jar,/home/apaas/account-rest,cd /home/apaas/account-rest;./accountserver.py restart,1");
        this.put("xw-uiprotocol-rest-0.1.0.jar","F:\\IdeaProjects\\Ui-Protocol-Service\\xw-uiprotocol-rest\\build\\libs\\xw-uiprotocol-rest-0.1.0.jar,/home/apaas/master-service,./uiprotocolserver.py restart,1");
    }
}
