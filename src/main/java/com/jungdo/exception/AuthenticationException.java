package com.jungdo.exception;

public class AuthenticationException extends Exception{
    private static final boolean ENABLE_SUPPRESSION = true;

    private static final boolean WRITABLE_STACK_TRACE = false;

    public AuthenticationException(String message) {
        super(message, null, ENABLE_SUPPRESSION, WRITABLE_STACK_TRACE);
    }
}
