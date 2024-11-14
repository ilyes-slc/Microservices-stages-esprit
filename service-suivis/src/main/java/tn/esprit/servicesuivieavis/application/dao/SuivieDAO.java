package tn.esprit.servicesuivieavis.application.dao;

import tn.esprit.servicesuivieavis.application.dto.NewSuivieDto;
import tn.esprit.servicesuivieavis.domain.Suivie;

import java.util.Date;
import java.util.List;
import java.util.Optional;





public interface SuivieDAO {
    Optional<Suivie> findSuivieByMotif(String motif);
    List<Suivie> findAllSuivies();
    void saveSuivie(NewSuivieDto suivie);
    void updateSuivie(Suivie newSuivie);
    void deleteSuivie(Suivie oldSuivie);
    Optional<Suivie> findSuivieById(Long suivieId);
}