package tn.esprit.servicesignature.exceptions;

public class SignatureAlreadyExistsException extends RuntimeException{
    public SignatureAlreadyExistsException(String message){
        super(message);
    }
}
