package com.ayy.service;

import com.ayy.bean.Poulet;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */

public interface PouletService {
    Poulet getPoulet(char taille);

    void usePoulet(char taille);

    void stockPoulet(char taille, int added);
}
