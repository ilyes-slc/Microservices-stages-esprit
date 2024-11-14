package tn.esprit.servicesignature.exceptions;

public class StageAlreadyExistsException extends RuntimeException{
    public StageAlreadyExistsException(String message){
        super(message);
    }
}
