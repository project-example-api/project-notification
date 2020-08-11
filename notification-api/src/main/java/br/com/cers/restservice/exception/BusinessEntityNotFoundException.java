package br.com.cers.restservice.exception;

import lombok.Getter;
import lombok.Setter;

public class BusinessEntityNotFoundException extends BusinessException {

    private static final long serialVersionUID = 1L;


    @Setter
    @Getter
    private String[] arguments;

    public BusinessEntityNotFoundException(String message) {
        super(message);
    }

    public BusinessEntityNotFoundException(String message, Throwable ex) {
        super(message, ex);
    }

    public BusinessEntityNotFoundException(String message, String[] arguments, Throwable ex) {
        super(message, ex);
        this.arguments = arguments;

    }

}
