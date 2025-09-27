package com.br.employee.exception;

public class UserIsAlreadyExistsException extends RuntimeException {

    public UserIsAlreadyExistsException(String msg) {
        super(msg);
    }

}
