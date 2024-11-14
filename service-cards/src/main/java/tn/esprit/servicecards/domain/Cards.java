package tn.esprit.servicecards.domain;

public record Cards(
        Long id,
        Long board,
        Long liste,
        String title,
        String description
) {
}
