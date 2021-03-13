package com.ayy.action;

import com.ayy.bean.Poulet;
import com.ayy.service.PouletService;
import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Controller("pouletAction")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class PouletAction extends ActionSupport {
    private PouletService pouletService;

    @Autowired
    public void setPouletService(PouletService pouletService) {
        this.pouletService = pouletService;
    }

    public String stock(){
        poulets = new ArrayList<>();
        poulets.add(pouletService.getPoulet('L'));
        poulets.add(pouletService.getPoulet('M'));
        poulets.add(pouletService.getPoulet('S'));
        PouletLog.logger.debug("Poulet stock");
        return Action.SUCCESS;
    }

    /* ------------------------ */
    private List<Poulet> poulets;

    public List<Poulet> getPoulets() {
        return poulets;
    }

    public void setPoulets(List<Poulet> poulets) {
        this.poulets = poulets;
    }
}
