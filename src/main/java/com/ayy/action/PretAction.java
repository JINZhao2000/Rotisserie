package com.ayy.action;

import com.ayy.bean.*;
import com.ayy.service.*;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 10/03/2021
 * @ Version 1.0
 */
@Controller("pretAction")
public class PretAction extends ActionSupport {
    private PretService pretService;
    private BacService bacService;
    private CommandeService commandeService;
    private PouletService pouletService;
    private WaitQueueService waitQueueService;
    private List<Commande> commandesPretes;
    private int bid = 0;
    private int numCom = 0;

    @Autowired
    public void setWaitQueueService(WaitQueueService waitQueueService) {
        this.waitQueueService = waitQueueService;
    }

    @Autowired
    public void setPretService(PretService pretService) {
        this.pretService = pretService;
    }

    @Autowired
    public void setBacService(BacService bacService) {
        this.bacService = bacService;
    }

    @Autowired
    public void setCommandeService(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    @Autowired
    public void setPouletService(PouletService pouletService) {
        this.pouletService = pouletService;
    }

    public String sortirDuBac(){
        Bac bac = bacService.getBac(bid);
        Commande commande = commandeService.getCommande(bac.getNumCom());
        Poulet poulet = pouletService.getPoulet(bac.getTaille());
        pretService.sortirDuBac(new Pret(commande,poulet));
        bacService.setVide(bac.getBid());
        bid = 0;
        return Action.SUCCESS;
    }

    public String commandesPretes(){
        commandesPretes = new ArrayList<>();
        List<Commande> commandes = pretService.getAllPret();
        List<Bac> bacList = bacService.getAllBacs();
        List<WaitQueue> waitQueueList = waitQueueService.getAll();
        commandes.forEach((commande)->{
            boolean flag = true;
            int numCom = commande.getNumCom();
            for (Bac bac : bacList) {
                if (bac.getNumCom() == numCom) {
                    flag = false;
                    break;
                }
            }
            for (WaitQueue waitQueue : waitQueueList) {
                if (waitQueue.getCommande().getNumCom() == numCom) {
                    flag = false;
                    break;
                }
            }
            if(flag){
                commandesPretes.add(commande);
            }
        });
        return Action.SUCCESS;
    }

    public String retirer(){
        pretService.retirer(numCom);
        numCom=0;
        return Action.SUCCESS;
    }

    public List<Commande> getCommandesPretes() {
        return commandesPretes;
    }

    public void setCommandesPretes(List<Commande> commandesPretes) {
        this.commandesPretes = commandesPretes;
    }

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }
}
