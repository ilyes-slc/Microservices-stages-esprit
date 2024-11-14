package tn.esprit.servicecards.application.dao;

import tn.esprit.servicecards.application.dto.NewCardsDto;
import tn.esprit.servicecards.domain.Cards;

import java.util.List;
import java.util.Optional;

public interface CardsDAO {

    List<Cards> findAllCards();
    void saveCards(NewCardsDto offre);
    void updateCards(Cards newCards);
    void deleteCards(Cards oldCards);
    Optional<Cards> findCardsById(Long offreId);
    List<Cards> findCardsByListID(Long ListID);

}
