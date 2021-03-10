package com.ayy.service.impl;

import com.ayy.bean.Manager;
import com.ayy.dao.ManagerDao;
import com.ayy.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 26/02/2021
 * @ Version 1.0
 */
@Service
public class ManagerServiceImpl implements ManagerService {
    private ManagerDao managerDao;

    @Autowired
    public void setManagerDao(ManagerDao managerDao) {
        this.managerDao = managerDao;
    }

    @Override
    public Manager getManager(String uname) {
        return managerDao.getManager(uname);
    }
}
