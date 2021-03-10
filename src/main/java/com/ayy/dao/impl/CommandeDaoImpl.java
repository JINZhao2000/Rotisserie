package com.ayy.dao.impl;

import com.ayy.bean.Commande;
import com.ayy.dao.CommandeDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */
@Repository
public class CommandeDaoImpl implements CommandeDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    @SuppressWarnings("all")
    public Commande addCommande(Commande commande) {
        template.save(commande);
        int id = template.execute(new HibernateCallback<Integer>() {
            @Override
            public Integer doInHibernate(Session session) throws HibernateException {
                String sql = "select last_insert_id()";
                List<BigInteger> res = session.createSQLQuery(sql).list();
                return res.get(0).intValue();
            }
        });
        return template.get(Commande.class,id);
    }

    @Override
    public Commande getCommande(int numCom) {
        return template.get(Commande.class,numCom);
    }
}
