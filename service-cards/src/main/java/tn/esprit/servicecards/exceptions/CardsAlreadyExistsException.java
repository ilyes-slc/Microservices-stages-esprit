package tn.esprit.servicecards.exceptions;

public class CardsAlreadyExistsException extends RuntimeException{
    public CardsAlreadyExistsException(String message){
        super(message);
    }
}
