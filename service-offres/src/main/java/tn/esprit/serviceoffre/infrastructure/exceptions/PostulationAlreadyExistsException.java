package tn.esprit.serviceoffre.infrastructure.exceptions;

public class PostulationAlreadyExistsException extends RuntimeException{
    public PostulationAlreadyExistsException(String message){
        super(message);
    }
}