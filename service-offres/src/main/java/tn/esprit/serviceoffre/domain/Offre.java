package tn.esprit.serviceoffre.domain;

import java.time.LocalDate;

public record Offre (
        Long id,
        LocalDate date,
        String title,
        Long idEntreprise,
        String description,
        String location,
        String remote,
        boolean easyApply

){


}
