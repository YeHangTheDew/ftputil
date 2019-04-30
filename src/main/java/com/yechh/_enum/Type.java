package com.yechh._enum;

/**
 * @author ：yechh
 * @date ：Created in 2019/4/30 9:37
 * @description：
 * @modified By：
 * @version: v1.0
 */
public enum Type {

    PLATFORM("2"),
    JAVA("1");


    private String index;
    private Type(String index){
        this.index=index;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }
}
