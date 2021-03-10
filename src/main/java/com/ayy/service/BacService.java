package com.ayy.service;

import com.ayy.bean.Bac;
import com.ayy.bean.Commande;
import com.ayy.bean.Poulet;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */

public interface BacService {
    Bac getBac(int bid);

    Bac getBacDispo();

    void setVide(int bid);

    void setOccupe(int bid, Commande commande, Poulet poulet);

    void setPret(int bid);

    List<Bac> getAllBacs();
}
