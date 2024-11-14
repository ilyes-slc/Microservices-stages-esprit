package tn.esprit.servicebords.application.dto;

import java.time.LocalDate;
import java.util.List;

public record NewBordsDto(

        Long id,
        String title,
        String description
) {

}
