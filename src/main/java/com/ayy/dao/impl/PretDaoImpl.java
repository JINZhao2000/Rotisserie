package com.ayy.dao.impl;

import com.ayy.bean.Commande;
import com.ayy.bean.Pret;
import com.ayy.dao.PretDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 01/03/2021
 * @ Version 1.0
 */
@Repository
public class PretDaoImpl implements PretDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void sortirDuBac(Pret pret) {
        template.save(pret);
    }

    @Override
    public void retirer(int numCom) {
        template.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql = "delete from pret where numCom = :n";
                NativeQuery sqlQuery = session.createSQLQuery(sql);
                sqlQuery.setParameter("n", numCom);
                sqlQuery.executeUpdate();
                return null;
            }
        });
    }

    @Override
    public List<Commande> getAllPret() {
        List<Integer> listCommande = template.execute(new HibernateCallback<List<Integer>>() {
            @Override
            public List<Integer> doInHibernate(Session session) throws HibernateException {
                String sql = "SELECT DISTINCT numCom FROM pret";
                return session.createSQLQuery(sql).list();
            }
        });
        List<Commande> commandes = new ArrayList<>();
        for (Integer integer : listCommande) {
            commandes.add(template.get(Commande.class,integer));
        }
        return commandes;
    }
}
