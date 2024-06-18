package com.example.MongoDb_SB.services.serviceException;

public class ObjectNotFoundException extends RuntimeException {

    public ObjectNotFoundException(String msg) {
        super(msg);
    }

}
