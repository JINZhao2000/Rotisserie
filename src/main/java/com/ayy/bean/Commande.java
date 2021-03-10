package com.ayy.bean;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
public class Commande {
    private int numCom;
    private String nomClient;
    private int frit;

    @Override
    public String toString() {
        return "Commande{" +
                "numCom=" + numCom +
                ", nomClient='" + nomClient + '\'' +
                ", frit=" + frit +
                '}';
    }

    public Commande() {}

    public Commande(String nomClient, int frit) {
        this.nomClient = nomClient;
        this.frit = frit;
    }

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public String getNomClient() {
        return nomClient;
    }

    public void setNomClient(String nomClient) {
        this.nomClient = nomClient;
    }

    public int getFrit() {
        return frit;
    }

    public void setFrit(int frit) {
        this.frit = frit;
    }
}
