package com.IOE.cs.city_sync.Expection;

public class AlreadyFinishedProjectException extends RuntimeException{
    public AlreadyFinishedProjectException(String message){
        super(message);
    }
}
