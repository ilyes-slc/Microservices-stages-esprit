package tn.esprit.servicesignature.exceptions;

public class SignatureNotFoundException extends RuntimeException{
    public SignatureNotFoundException(String s){
        super(s);
    }
}
