package com.ayy.dao;

import com.ayy.bean.WaitQueue;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 01/03/2021
 * @ Version 1.0
 */
public interface WaitQueueDao {
    void add(WaitQueue waitQueue);

    List<WaitQueue> getAll();

    void delete(int wid);

    WaitQueue getWaitQueue(int wid);
}
