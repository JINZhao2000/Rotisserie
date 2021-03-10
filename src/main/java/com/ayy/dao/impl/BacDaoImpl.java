package com.ayy.dao.impl;

import com.ayy.bean.Bac;
import com.ayy.bean.Commande;
import com.ayy.bean.Poulet;
import com.ayy.dao.BacDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
@Repository
public class BacDaoImpl implements BacDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Bac getBac(int bid) {
        return template.get(Bac.class,bid);
    }

    @Override
    public Bac getBacDispo() {
        Bac bac = null;
        for (int i = 0; i < Bac.NB_BAC; i++) {
            bac = getBac(i+1);
            if(bac.getStatuts()==0){
                break;
            }
        }
        return bac;
    }

    @Override
    public void setVide(int bid) {
        Bac bac = getBac(bid);
        bac.setStatuts(0);
        bac.setNumCom(0);
        bac.setTaille('N');
        template.saveOrUpdate(bac);
    }

    @Override
    public void setOccupe(int bid, Commande commande, Poulet poulet) {
        Bac bac = getBac(bid);
        bac.setStatuts(1);
        bac.setTaille(poulet.getTaille());
        bac.setNumCom(commande.getNumCom());
        template.saveOrUpdate(bac);
    }

    @Override
    public void setPret(int bid) {
        Bac bac = getBac(bid);
        bac.setStatuts(2);
        template.saveOrUpdate(bac);
    }

    @Override
    public List<Bac> getAllBacs() {
        return template.loadAll(Bac.class);
    }
}
