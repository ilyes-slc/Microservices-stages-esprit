package tn.esprit.servicecards.application.dto;

public record NewCardsDto(
        Long id,
        Long board,
        Long liste,
        String title,
        String description

) {
}
