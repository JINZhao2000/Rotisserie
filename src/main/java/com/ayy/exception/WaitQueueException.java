package com.ayy.exception;

/**
 * @ Description
 * @ Author Zhao JIN
 * @ Date 02/03/2021
 * @ Version 1.0
 */
public class WaitQueueException extends RuntimeException{
    public WaitQueueException() {
    }

    public WaitQueueException(String message) {
        super(message);
    }
}
