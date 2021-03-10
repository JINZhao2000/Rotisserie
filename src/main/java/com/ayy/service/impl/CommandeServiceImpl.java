package com.ayy.service.impl;

import com.ayy.bean.Commande;
import com.ayy.dao.CommandeDao;
import com.ayy.exception.CommandeException;
import com.ayy.service.CommandeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Service
public class CommandeServiceImpl implements CommandeService {
    private CommandeDao commandeDao;

    @Autowired
    public void setCommandeDao(CommandeDao commandeDao) {
        this.commandeDao = commandeDao;
    }

    @Override
    public Commande addCommande(Commande commande) {
        if(commande.getNumCom()!=0){
            throw new CommandeException("Commande invalid");
        }
        return commandeDao.addCommande(commande);
    }

    @Override
    public Commande getCommande(int numCom) {
        if (numCom<=0){
            throw new CommandeException("Commande num out of bound");
        }
        return commandeDao.getCommande(numCom);
    }
}
