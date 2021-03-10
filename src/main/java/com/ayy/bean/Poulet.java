package com.ayy.bean;

import java.sql.Time;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
public class Poulet {
    private char taille;
    private Time temps;
    private int stock;

    @Override
    public String toString() {
        return "Poulet{" +
                "taille=" + taille +
                ", temps=" + temps +
                ", stock=" + stock +
                '}';
    }

    public Poulet() {}

    public char getTaille() {
        return taille;
    }

    public void setTaille(char taille) {
        this.taille = taille;
    }

    public Time getTemps() {
        return temps;
    }

    public void setTemps(Time temps) {
        this.temps = temps;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
