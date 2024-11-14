package tn.esprit.servicestage.domain;

import java.time.LocalDate;

public record Stage (
        Long id,
        LocalDate datedebut,
        LocalDate datefin,
        String type,
        Long idEtudiant,
        String lien,
        String tuteurAcademique,
        String entreprise
) {
    // You can add any additional methods or customization here if needed
}
