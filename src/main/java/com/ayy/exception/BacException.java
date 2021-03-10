package com.ayy.exception;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
public class BacException extends RuntimeException{
    public BacException() {
    }

    public BacException(String message) {
        super(message);
    }
}
