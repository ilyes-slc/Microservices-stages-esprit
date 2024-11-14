package tn.esprit.serviceoffre.application.dto;

import java.time.LocalDate;

public record NewOffreDto (
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