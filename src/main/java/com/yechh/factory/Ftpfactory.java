package com.yechh.factory;

import com.yechh._enum.Type;
import com.yechh.domain.Ftp;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/30 9:25
 * @description：
 * @modified By：
 * @version: v1.0
 */
public class Ftpfactory {

    public static Ftp getFtp(String type){
        Ftp ftp=null;
        if (type.equals(Type.PLATFORM.getIndex())) {
            ftp=new Ftp("172.16.0.125","root","xwaPaaS@2017.",22);
            return ftp;
        }
        else {
            ftp=new Ftp("172.16.0.139","root","xwaPaaS@2017.",22);
            return ftp;
        }


    }
}
