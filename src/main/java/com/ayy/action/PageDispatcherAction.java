package com.ayy.action;

import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Controller("pageDispatcherAction")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PageDispatcherAction extends ActionSupport {
    public String toLogin() {
        PouletLog.logger.debug("To page login");
        return Action.SUCCESS;
    }

    public String toIndex() {
        PouletLog.logger.debug("To page index");
        return Action.SUCCESS;
    }

    public String toPrise() {
        PouletLog.logger.debug("To page prise");
        return Action.SUCCESS;
    }

    public String toPanneau() {
        PouletLog.logger.debug("To page panneau");
        return Action.SUCCESS;
    }
}
