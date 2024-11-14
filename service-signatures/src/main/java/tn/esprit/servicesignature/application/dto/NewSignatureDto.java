package tn.esprit.servicesignature.application.dto;

import java.time.LocalDate;

public record NewSignatureDto(

        Long id,
        String nom,
        String email,
        Long clepublique,
        String algo,
        LocalDate datevalide,
        String etat
) {
}
