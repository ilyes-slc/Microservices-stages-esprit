package tn.esprit.servicestage.application.dto;

import java.time.LocalDate;

public record NewStageDto(
        Long id,
        LocalDate datedebut,
        LocalDate datefin,
        String type,
        Long idEtudiant,
        String lien,
        String tuteurAcademique,
        String entreprise


) {
}
