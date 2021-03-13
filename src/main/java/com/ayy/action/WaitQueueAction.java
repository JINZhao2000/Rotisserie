package com.ayy.action;

import com.ayy.bean.WaitQueue;
import com.ayy.service.WaitQueueService;
import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Controller("waitQueueAction")
@Scope(WebApplicationContext.SCOPE_SESSION)
public class WaitQueueAction {
    private WaitQueueService waitQueueService;

    @Autowired
    public void setWaitQueueService(WaitQueueService waitQueueService) {
        this.waitQueueService = waitQueueService;
    }

    public String queue(){
        waitQueues = waitQueueService.getAll();
        PouletLog.logger.info("Queue got");
        return Action.SUCCESS;
    }

    /* ------------------------ */
    private List<WaitQueue> waitQueues;

    public List<WaitQueue> getWaitQueues() {
        return waitQueues;
    }

    public void setWaitQueues(List<WaitQueue> waitQueues) {
        this.waitQueues = waitQueues;
    }
}
