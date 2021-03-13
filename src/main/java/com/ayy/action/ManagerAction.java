package com.ayy.action;

import com.ayy.bean.Manager;
import com.ayy.service.ManagerService;
import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Controller("managerAction")
public class ManagerAction extends ActionSupport {
    private ManagerService managerService;

    @Autowired
    public void setManagerService(ManagerService managerService) {
        this.managerService = managerService;
    }

    public String login(){
        Manager manager = managerService.getManager(uname);
        if (pwd.equals("")|pwd.hashCode()!= manager.getPwd()){
            return Action.LOGIN;
        }
        ActionContext.getContext().getSession().put("manager",manager);
        PouletLog.logger.info("Login Success");
        return Action.SUCCESS;
    }

    public String logout(){
        uname="";
        pwd="";
        ActionContext.getContext().getSession().put("manager",null);
        PouletLog.logger.info("Logout Success");
        return Action.SUCCESS;
    }

    /* ------------------------ */
    private String uname;
    private String pwd;

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
