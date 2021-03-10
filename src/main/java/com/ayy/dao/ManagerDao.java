package com.ayy.dao;

import com.ayy.bean.Manager;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 26/02/2021
 * @ Version 1.0
 */
public interface ManagerDao {
    Manager getManager(String uname);
}
