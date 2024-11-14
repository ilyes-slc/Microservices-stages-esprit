package tn.esprit.serviceoffre.application.dao;

import tn.esprit.serviceoffre.application.dto.NewOffreDto;
import tn.esprit.serviceoffre.domain.Offre;

import java.util.List;
import java.util.Optional;

public interface OffreDAO {
    Optional<Offre> findOffreByTitle(String title);
    List<Offre> findAllOffres();
    void saveOffre(NewOffreDto offre);
    void updateOffre(Offre newOffre);
    void deleteOffre(Offre oldOffre);
    Optional<Offre> findOffreById(Long offreId);
}
