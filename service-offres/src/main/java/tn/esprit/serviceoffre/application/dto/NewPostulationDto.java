package tn.esprit.serviceoffre.application.dto;

import java.time.LocalDate;

public record NewPostulationDto (

         Long idPostulation,
         Long idOffre,
         Long idUser,
         LocalDate datePostulation,
         String cv,
         String lettreMotivation,
         String etatPostulation
)
{

}

