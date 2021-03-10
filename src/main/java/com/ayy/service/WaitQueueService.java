package com.ayy.service;

import com.ayy.bean.WaitQueue;

import java.util.List;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
public interface WaitQueueService {
    void add(WaitQueue waitQueue);

    List<WaitQueue> getAll();

    WaitQueue delete(int wid);
}
