package com.ayy.service.impl;

import com.ayy.bean.Poulet;
import com.ayy.dao.PouletDao;
import com.ayy.exception.PouletException;
import com.ayy.service.PouletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Service
public class PouletServiceImpl implements PouletService {
    private PouletDao pouletDao;

    @Autowired
    public void setPouletDao(PouletDao pouletDao) {
        this.pouletDao = pouletDao;
    }

    @Override
    public Poulet getPoulet(char taille) {
        checkPoulet(taille);
        return pouletDao.getPoulet(taille);
    }

    @Override
    public void usePoulet(char taille) {
        checkPoulet(taille);
        Poulet p = getPoulet(taille);
        if(p.getStock()==0){
            throw new PouletException("Insuffisant de poulet");
        }
        pouletDao.usePoulet(taille);
    }

    @Override
    public void stockPoulet(char taille, int added) {
        checkPoulet(taille);
        if(added<0){
            throw new PouletException("Invalid added");
        }
        pouletDao.stockPoulet(taille,added);
    }

    private void checkPoulet(char taille){
        if (taille!='L'&&taille!='M'&&taille!='S'){
            throw new PouletException("Unknown taille de poulet");
        }
    }
}
