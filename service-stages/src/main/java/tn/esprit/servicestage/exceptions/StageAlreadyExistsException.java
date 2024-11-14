package tn.esprit.servicestage.exceptions;

public class StageAlreadyExistsException extends RuntimeException{
    public StageAlreadyExistsException(String message){
        super(message);
    }
}
