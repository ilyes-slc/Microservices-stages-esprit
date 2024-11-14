package tn.esprit.servicesuivieavis.domain;

import java.util.Date;

public record Suivie(


        Long id,
        Long idIncadrant,
        Long idEtudiant,
        Date date,
        String motif,
        String ressource




) {
}
