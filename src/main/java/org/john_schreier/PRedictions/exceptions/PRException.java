package org.john_schreier.PRedictions.exceptions;


//  Custom exception which can be specified for different contexts
public class PRException extends Exception{
    public PRException(String errorMessage) {
        super(errorMessage);
    }
}
