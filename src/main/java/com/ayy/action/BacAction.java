package com.ayy.action;

import com.ayy.bean.Bac;
import com.ayy.bean.WaitQueue;
import com.ayy.service.BacService;
import com.ayy.service.WaitQueueService;
import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.WebApplicationContext;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 10/03/2021
 * @ Version 1.0
 */
@Controller("bacAction")
public class BacAction extends ActionSupport {
    private BacService bacService;
    private WaitQueueService waitQueueService;


    @Autowired
    public void setBacService(BacService bacService) {
        this.bacService = bacService;
    }

    @Autowired
    public void setWaitQueueService(WaitQueueService waitQueueService) {
        this.waitQueueService = waitQueueService;
    }

    public String getAllBac(){
        allBacs = bacService.getAllBacs();
        PouletLog.logger.info("Bacs got");
        return Action.SUCCESS;
    }

    public String mettreAuBac(){
        WaitQueue tmp = waitQueueService.delete(mab);
        Bac bacDispo = bacService.getBacDispo();
        bacService.setOccupe(bacDispo.getBid(),tmp.getCommande(),tmp.getPoulet());
        mab = 0;
        long milleTime = getMilleTime(tmp.getPoulet().getTemps());
        new Thread(()->{
            try {
                Thread.sleep(milleTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            bacService.setPret(bacDispo.getBid());
        }).start();
        return Action.SUCCESS;
    }

    /* ------------------------ */

    private static DateFormat format = new SimpleDateFormat("HH:mm:ss");
    private int mab = 0;
    private List<Bac> allBacs;

    public List<Bac> getAllBacs() {
        return allBacs;
    }

    public void setAllBacs(List<Bac> allBacs) {
        this.allBacs = allBacs;
    }

    public int getMab() {
        return mab;
    }

    public void setMab(int mab) {
        this.mab = mab;
    }

    public static long getMilleTime(Time time){
        String formattedTime = format.format(time);
        String[] split = formattedTime.split(":");
        long milles = Integer.parseInt(split[0])*3600 + Integer.parseInt(split[1])*60+Integer.parseInt(split[2]);
        return milles*1000;
    }
}
