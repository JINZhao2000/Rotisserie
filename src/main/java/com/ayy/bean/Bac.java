package com.ayy.bean;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
public class Bac {
    public static final int NB_BAC = 10;
    private int bid;
    private int statuts;
    private int numCom;
    private char taille;

    @Override
    public String toString() {
        return "Bac{" +
                "bid=" + bid +
                ", statuts=" + statuts +
                ", numCom=" + numCom +
                ", taille=" + taille +
                '}';
    }

    public Bac() {}

    public int getBid() {
        return bid;
    }

    public void setBid(int bid) {
        this.bid = bid;
    }

    public int getStatuts() {
        return statuts;
    }

    public void setStatuts(int statuts) {
        this.statuts = statuts;
    }

    public int getNumCom() {
        return numCom;
    }

    public void setNumCom(int numCom) {
        this.numCom = numCom;
    }

    public char getTaille() {
        return taille;
    }

    public void setTaille(char taille) {
        this.taille = taille;
    }
}
