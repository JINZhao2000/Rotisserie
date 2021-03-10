package com.ayy.dao.impl;

import com.ayy.bean.Manager;
import com.ayy.dao.ManagerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 26/02/2021
 * @ Version 1.0
 */
@Repository
public class ManagerDaoImpl implements ManagerDao {
    private HibernateTemplate template;

    @Autowired
    public void setTemplate(HibernateTemplate template) {
        this.template = template;
    }

    @Override
    public Manager getManager(String uname) {
        return template.get(Manager.class, uname);
    }
}
