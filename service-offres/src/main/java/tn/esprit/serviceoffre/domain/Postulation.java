package tn.esprit.serviceoffre.domain;

import java.time.LocalDate;

public record Postulation (


        Long idPostulation,
        Long idOffre,
        Long idUser,
        LocalDate datePostulation,
        String cv,
        String lettreMotivation,
        String etatPostulation
){
}
