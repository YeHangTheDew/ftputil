package com.yechh.domain;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/28 9:46
 * @description：
 * @modified By：
 * @version: v1.0
 */
/**
 * ftp链接常量
 *
 */
public class Ftp {

    //账号
    private String user;
    //主机ip
    private String host;
    //密码
    private String password;
    //端口
    private int port;

    public Ftp(String host,String user,String password,int port){
        this.user=user;
        this.host=host;
        this.password=password;
        this.port=port;
    }


    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

}
