package com.ayy.action;

import com.ayy.bean.Commande;
import com.ayy.bean.WaitQueue;
import com.ayy.service.CommandeService;
import com.ayy.service.PouletService;
import com.ayy.service.WaitQueueService;
import com.ayy.util.PouletLog;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Controller("commandeAction")
public class CommandeAction extends ActionSupport {
    private CommandeService commandeService;
    private WaitQueueService waitQueueService;
    private PouletService pouletService;

    @Autowired
    public void setPouletService(PouletService pouletService) {
        this.pouletService = pouletService;
    }

    @Autowired
    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Autowired
    public void setWaitQueueService(WaitQueueService waitQueueService) {
        this.waitQueueService = waitQueueService;
    }

    public String saveCommande(){
        try {
            Commande commande = commandeService.addCommande(new Commande(cnom, frit));
            PouletLog.logger.info("Commande saved");
            for (int i = 0; i < nL; i++) {
                waitQueueService.add(new WaitQueue(commande, pouletService.getPoulet('L')));
                pouletService.usePoulet('L');
                PouletLog.logger.info("Un poulet L -1");
            }
            PouletLog.logger.info("Poulet L added");
            for (int i = 0; i < nM; i++) {
                waitQueueService.add(new WaitQueue(commande, pouletService.getPoulet('M')));
                pouletService.usePoulet('M');
                PouletLog.logger.info("Un poulet M -1");
            }
            PouletLog.logger.info("Poulet M added");
            for (int i = 0; i < nS; i++) {
                waitQueueService.add(new WaitQueue(commande, pouletService.getPoulet('S')));
                pouletService.usePoulet('S');
                PouletLog.logger.info("Un poulet M -1");
            }
            PouletLog.logger.info("Poulet S added");
        }catch (Exception e){
            PouletLog.logger.fatal("Commande ou poulet can't be saved");
            return Action.ERROR;
        }
        PouletLog.logger.info("Commande et poulet saved");
        return Action.SUCCESS;
    }

    /* ------------------------ */
    private String cnom;
    private int frit;
    private int nL;
    private int nM;
    private int nS;

    public String getCnom() {
        return cnom;
    }

    public void setCnom(String cnom) {
        this.cnom = cnom;
    }

    public int getFrit() {
        return frit;
    }

    public void setFrit(int frit) {
        this.frit = frit;
    }

    public int getnL() {
        return nL;
    }

    public void setnL(int nL) {
        this.nL = nL;
    }

    public int getnM() {
        return nM;
    }

    public void setnM(int nM) {
        this.nM = nM;
    }

    public int getnS() {
        return nS;
    }

    public void setnS(int nS) {
        this.nS = nS;
    }
}
