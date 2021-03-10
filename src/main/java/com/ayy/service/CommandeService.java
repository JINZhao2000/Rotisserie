package com.ayy.service;

import com.ayy.bean.Commande;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */

public interface CommandeService {
    Commande addCommande(Commande commande);

    Commande getCommande(int numCom);
}
