package com.lcdw.user.service.exception;

public class ResourceNotFoundException extends RuntimeException{


    //extra properties that you want to manage



    public ResourceNotFoundException() {
        super("ResourceNotFoundException");
    }


    public ResourceNotFoundException(String message){
        super(message);
    }
}
