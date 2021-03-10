package com.ayy.dao.impl;

import com.ayy.bean.Poulet;
import com.ayy.dao.PouletDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 01/03/2021
 * @ Version 1.0
 */
@Repository
public class PouletDaoImpl implements PouletDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Poulet getPoulet(char taille) {
        return template.get(Poulet.class,taille);
    }

    @Override
    public void usePoulet(char taille) {
        Poulet poulet = getPoulet(taille);
        poulet.setStock(poulet.getStock()-1);
        template.saveOrUpdate(poulet);
    }

    @Override
    public void stockPoulet(char taille, int added) {
        Poulet poulet = getPoulet(taille);
        poulet.setStock(poulet.getStock()+added);
        template.saveOrUpdate(poulet);
    }
}
