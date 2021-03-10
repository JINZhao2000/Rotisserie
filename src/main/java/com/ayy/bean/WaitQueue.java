package com.ayy.bean;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
public class WaitQueue {
    private int wid;
    private Commande commande;
    private Poulet poulet;

    @Override
    public String toString() {
        return "WaitQueue{" +
                "wid=" + wid +
                ", commande=" + commande +
                ", poulet=" + poulet +
                '}';
    }

    public WaitQueue() {}

    public WaitQueue(Commande commande, Poulet poulet) {
        this.commande = commande;
        this.poulet = poulet;
    }

    public int getWid() {
        return wid;
    }

    public void setWid(int wid) {
        this.wid = wid;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    public Poulet getPoulet() {
        return poulet;
    }

    public void setPoulet(Poulet poulet) {
        this.poulet = poulet;
    }
}
