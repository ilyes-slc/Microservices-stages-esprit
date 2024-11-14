package tn.esprit.servicesuivieavis.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.servicesuivieavis.adapters.out.postgresJDBC.entities.SuivieEntity;
import tn.esprit.servicesuivieavis.domain.Suivie;

import java.util.Optional;

@Repository
public interface SuiviesRepository extends CrudRepository<SuivieEntity,Long> {

    Optional<Suivie> findSuivieByMotif(String Motif);
    Optional<Suivie> findSuivieById(Long id);
}
