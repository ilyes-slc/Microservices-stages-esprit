package tn.esprit.servicesignature.domain;

import java.time.LocalDate;

public record Signature(
    Long id,
    String nom,
    String email,
    Long clepublique,
    String algo,
    LocalDate datevalide,
    String etat



) {
}
