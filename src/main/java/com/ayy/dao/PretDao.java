package com.ayy.dao;

import com.ayy.bean.Commande;
import com.ayy.bean.Pret;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 01/03/2021
 * @ Version 1.0
 */

public interface PretDao {
    void sortirDuBac(Pret pret);

    void retirer(int numCom);

    List<Commande> getAllPret();
}
