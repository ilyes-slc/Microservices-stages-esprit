package tn.esprit.serviceoffre.infrastructure.exceptions;

public class OffreNotFoundException extends RuntimeException{
    public OffreNotFoundException(String s){
        super(s);
    }
}
