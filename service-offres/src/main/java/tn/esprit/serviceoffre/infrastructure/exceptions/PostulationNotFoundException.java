package tn.esprit.serviceoffre.infrastructure.exceptions;

import tn.esprit.serviceoffre.domain.Postulation;

public class PostulationNotFoundException extends RuntimeException{
    public PostulationNotFoundException(String s){
        super(s);
    }
}
