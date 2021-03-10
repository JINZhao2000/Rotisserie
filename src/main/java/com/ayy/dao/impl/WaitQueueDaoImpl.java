package com.ayy.dao.impl;

import com.ayy.bean.WaitQueue;
import com.ayy.dao.WaitQueueDao;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.NativeQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateCallback;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Repository
public class WaitQueueDaoImpl implements WaitQueueDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public void add(WaitQueue waitQueue) {
        template.saveOrUpdate(waitQueue);
    }

    @Override
    public List<WaitQueue> getAll() {
        return template.loadAll(WaitQueue.class);
    }

    @Override
    public void delete(int wid) {
        template.execute(new HibernateCallback<Object>() {
            @Override
            public Object doInHibernate(Session session) throws HibernateException {
                String sql = "delete from waitqueue where wid = ?";
                NativeQuery sqlQuery = session.createSQLQuery(sql);
                sqlQuery.setParameter(1,wid);
                sqlQuery.executeUpdate();
                return null;
            }
        });
    }

    @Override
    public WaitQueue getWaitQueue(int wid) {
        return template.get(WaitQueue.class,wid);
    }
}
