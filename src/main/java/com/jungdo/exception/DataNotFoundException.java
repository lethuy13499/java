package com.jungdo.exception;

public class DataNotFoundException extends Exception{
    private static boolean enableSuppression = true;

    private static boolean writableStackTrace = false;

    public DataNotFoundException() {
        super("data not found", null, enableSuppression, writableStackTrace);
    }
}
