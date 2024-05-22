package com.behl.cerberus.UtilsRestaurant.exception.impl;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidOrIncompleteDataException extends  RuntimeException{

    public InvalidOrIncompleteDataException (String message){
        super(message);
    }
}
