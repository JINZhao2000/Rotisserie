package com.ayy.dao;

import com.ayy.bean.Poulet;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 28/02/2021
 * @ Version 1.0
 */

public interface PouletDao {
    Poulet getPoulet(char taille);

    void usePoulet(char taille);

    void stockPoulet(char taille, int added);
}
