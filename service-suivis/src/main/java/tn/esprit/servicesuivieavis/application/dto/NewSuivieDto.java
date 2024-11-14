package tn.esprit.servicesuivieavis.application.dto;

import java.util.Date;

public record NewSuivieDto(
        Long id,
        Long idIncadrant,
        Long idEtudiant,
        Date date,
        String motif,
        String ressource
) {
}
