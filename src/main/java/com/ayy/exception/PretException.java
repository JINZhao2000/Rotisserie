package com.ayy.exception;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
public class PretException extends RuntimeException{
    public PretException() {
    }

    public PretException(String message) {
        super(message);
    }
}
