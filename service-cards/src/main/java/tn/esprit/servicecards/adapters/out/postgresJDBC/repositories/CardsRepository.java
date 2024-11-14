package tn.esprit.servicecards.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import tn.esprit.servicecards.adapters.out.postgresJDBC.entities.CardsEntity;
import tn.esprit.servicecards.domain.Cards;

import java.util.List;
import java.util.Optional;

public interface CardsRepository extends CrudRepository<CardsEntity,Long> {

    Optional<Cards> findCardsById(Long id);
    List<Cards> findCardsByliste(Long id);
    Optional<Cards> findCardsByTitle(String title);

}

