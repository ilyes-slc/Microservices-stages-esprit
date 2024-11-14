package tn.esprit.servicestage.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.servicestage.adapters.out.postgresJDBC.entities.StageEntity;
import tn.esprit.servicestage.domain.Stage;

import java.util.Optional;

@Repository
public interface StagesRepository extends CrudRepository<StageEntity, Long> {
    Optional<Stage> findStageByType(String type);
    Optional<Stage> findStageById(Long id);
}
