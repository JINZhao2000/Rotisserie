package com.ayy.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;


/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
@Component
public class PouletLog {
    public static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
}
