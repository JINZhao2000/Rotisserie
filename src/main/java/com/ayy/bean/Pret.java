package com.ayy.bean;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
public class Pret {
    private int pid;
    private Commande commande;
    private Poulet poulet;

    @Override
    public String toString() {
        return "Pret{" +
                "pid=" + pid +
                ", commande=" + commande +
                ", poulet=" + poulet +
                '}';
    }

    public Pret() {}

    public Pret(Commande commande, Poulet poulet) {
        this.commande = commande;
        this.poulet = poulet;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
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
