package com.ayy.dao;

import com.ayy.bean.Commande;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */

public interface CommandeDao {
    Commande addCommande(Commande commande);

    Commande getCommande(int numCom);
}
