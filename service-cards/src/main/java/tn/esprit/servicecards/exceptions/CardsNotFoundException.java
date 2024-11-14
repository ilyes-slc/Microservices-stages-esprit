package tn.esprit.servicecards.exceptions;

public class CardsNotFoundException extends RuntimeException{
    public CardsNotFoundException(String s){
        super(s);
    }
}
