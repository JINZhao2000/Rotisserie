package com.ayy.bean;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 26/02/2021
 * @ Version 1.0
 */
public class Manager {
    private String uname;
    private int pwd;

    public Manager() {}

    public Manager(String uname, int pwd) {
        this.uname = uname;
        this.pwd = pwd;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "uname='" + uname + "'}";
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public int getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd.hashCode();
    }

    public void setPwd(int pwd) {
        this.pwd = pwd;
    }
}
