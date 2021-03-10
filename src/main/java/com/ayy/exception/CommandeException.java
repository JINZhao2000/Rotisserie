package com.ayy.exception;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
public class CommandeException extends RuntimeException{
    public CommandeException() {
    }

    public CommandeException(String message) {
        super(message);
    }
}
