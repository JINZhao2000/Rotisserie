package com.ayy.service.impl;

import com.ayy.bean.Bac;
import com.ayy.bean.Commande;
import com.ayy.bean.Poulet;
import com.ayy.dao.BacDao;
import com.ayy.exception.BacException;
import com.ayy.service.BacService;
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
public class BacServiceImpl implements BacService {
    private BacDao bacDao;

    @Autowired
    public void setBacDao(BacDao bacDao) {
        this.bacDao = bacDao;
    }

    @Override
    public Bac getBac(int bid) {
        checkBid(bid);
        return bacDao.getBac(bid);
    }

    @Override
    public Bac getBacDispo() {
        return bacDao.getBacDispo();
    }

    @Override
    public void setVide(int bid) {
        checkBid(bid);
        bacDao.setVide(bid);
    }

    @Override
    public void setOccupe(int bid, Commande commande, Poulet poulet) {
        checkBid(bid);
        bacDao.setOccupe(bid,commande,poulet);
    }

    @Override
    public void setPret(int bid) {
        checkBid(bid);
        bacDao.setPret(bid);
    }

    @Override
    public List<Bac> getAllBacs() {
        return bacDao.getAllBacs();
    }

    private void checkBid(int bid){
        if(bid>Bac.NB_BAC||bid<=0){
            throw new BacException("Bid out of bound");
        }
    }
}
