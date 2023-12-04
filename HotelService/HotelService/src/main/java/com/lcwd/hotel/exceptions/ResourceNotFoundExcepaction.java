package com.lcwd.hotel.exceptions;

public class ResourceNotFoundExcepaction extends RuntimeException {
    public ResourceNotFoundExcepaction(String s) {
        super(s);
    }

    public ResourceNotFoundExcepaction(){
        super(" Resource Not Found Excepaction !!");
    }
}
