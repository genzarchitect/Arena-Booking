package com.shamon.groundservice.exception;

public class GroundAlreadyExistsException extends RuntimeException {
    public GroundAlreadyExistsException(String message){
        super(message);
    }
}
