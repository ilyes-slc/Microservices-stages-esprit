package tn.esprit.servicestage.exceptions;

public class StageNotFoundException extends RuntimeException{
    public StageNotFoundException(String s){
        super(s);
    }
}
