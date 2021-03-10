package com.ayy.service.impl;


import com.ayy.bean.WaitQueue;
import com.ayy.dao.WaitQueueDao;
import com.ayy.exception.WaitQueueException;
import com.ayy.service.WaitQueueService;
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
public class WaitQueueServiceImpl implements WaitQueueService {
    private WaitQueueDao waitQueueDao;

    @Autowired
    public void setWaitQueueDao(WaitQueueDao waitQueueDao) {
        this.waitQueueDao = waitQueueDao;
    }

    @Override
    public void add(WaitQueue waitQueue) {
        waitQueueDao.add(waitQueue);
    }

    @Override
    public List<WaitQueue> getAll() {
        return waitQueueDao.getAll();
    }

    @Override
    public WaitQueue delete(int wid) {
        if(wid<=0){
            throw new WaitQueueException("Invalid wid");
        }
        WaitQueue waitQueue = waitQueueDao.getWaitQueue(wid);
        waitQueueDao.delete(wid);
        return waitQueue;
    }
}
