package tn.esprit.serviceoffre.infrastructure.exceptions;

import tn.esprit.serviceoffre.domain.Offre;

public class OffreAlreadyExistsException extends RuntimeException{
    public OffreAlreadyExistsException(String message){
        super(message);
    }
}
