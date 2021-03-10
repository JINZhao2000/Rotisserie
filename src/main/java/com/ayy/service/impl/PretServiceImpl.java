package com.ayy.service.impl;

import com.ayy.bean.Commande;
import com.ayy.bean.Pret;
import com.ayy.dao.PretDao;
import com.ayy.exception.PretException;
import com.ayy.service.PretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Service
public class PretServiceImpl implements PretService {
    private PretDao pretDao;

    @Autowired
    public void setPretDao(PretDao pretDao) {
        this.pretDao = pretDao;
    }

    @Override
    public void sortirDuBac(Pret pret) {
        pretDao.sortirDuBac(pret);
    }

    @Override
    public void retirer(int numCom) {
        if(numCom<=0){
            throw new PretException("Invalid num commande");
        }
        pretDao.retirer(numCom);
    }

    @Override
    public List<Commande> getAllPret() {
        return pretDao.getAllPret();
    }
}
