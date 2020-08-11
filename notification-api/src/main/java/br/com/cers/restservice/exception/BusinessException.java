package br.com.cers.restservice.exception;

import lombok.Getter;
import lombok.Setter;

/**
 * Custom Business Exception
 * 
 * 
 * @author carlos.e.gorges
 *
 */
public class BusinessException extends Exception {

    private static final long serialVersionUID = 1L;


    @Setter
    @Getter
    private String[] arguments;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(String message, Throwable ex) {
        super(message, ex);
    }

    public BusinessException(String message, String[] arguments, Throwable ex) {
        super(message, ex);
        this.arguments = arguments;

    }

}
