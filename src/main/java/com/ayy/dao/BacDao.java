package com.ayy.dao;

import com.ayy.bean.Bac;
import com.ayy.bean.Commande;
import com.ayy.bean.Poulet;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */

public interface BacDao {
    Bac getBac(int bid);

    Bac getBacDispo();

    void setVide(int bid);

    void setOccupe(int bid, Commande commande, Poulet poulet);

    void setPret(int bid);

    List<Bac> getAllBacs();
}
