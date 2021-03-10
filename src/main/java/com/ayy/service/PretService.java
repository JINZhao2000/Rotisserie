package com.ayy.service;

import com.ayy.bean.Commande;
import com.ayy.bean.Pret;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */

public interface PretService {
    void sortirDuBac(Pret pret);

    void retirer(int numCom);

    List<Commande> getAllPret();
}
