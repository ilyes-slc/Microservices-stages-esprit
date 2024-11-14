package tn.esprit.servicebords.exceptions;

public class BordsAlreadyExistsException extends RuntimeException{
    public BordsAlreadyExistsException(String message){
        super(message);
    }
}
