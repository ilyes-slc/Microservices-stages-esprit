package tn.esprit.servicecards.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.servicecards.application.dao.CardsDAO;
import tn.esprit.servicecards.application.dto.NewCardsDto;
import tn.esprit.servicecards.domain.Cards;
import tn.esprit.servicecards.exceptions.CardsAlreadyExistsException;
import tn.esprit.servicecards.exceptions.CardsNotFoundException;

import java.util.List;
@RequiredArgsConstructor
@Service
@Slf4j
public class CardsUseCase {
    private final CardsDAO cardsDAO;

    public String saveCards(NewCardsDto newCardsDto) throws CardsAlreadyExistsException {
        // Check if the cards is already in the database
        var isPresent = cardsDAO.findCardsById(newCardsDto.id()).isPresent();
        if (isPresent) {
            throw new CardsAlreadyExistsException("Cards already exists");
        }

        // Continue to save the cards
        cardsDAO.saveCards(newCardsDto);

        return "Cards Saved Successfully";
    }

    public List<Cards> getAllCards() {
        return cardsDAO.findAllCards();
    }

    public String updateCards(Cards cards) throws CardsNotFoundException {
        // Check if the cards exists in the database
        var isPresent = cardsDAO.findCardsById(cards.id()).isPresent();
        if (!isPresent) {
            throw new CardsNotFoundException("This cards does not exist");
        }

        cardsDAO.updateCards(cards);

        return "Cards Successfully updated";
    }


    public Cards getCardsByid(Long id) {
        return cardsDAO.findCardsById(id).orElseThrow(
                () -> new CardsNotFoundException("This Cards does not exist")
        );
    }


    public List<Cards> getCardsByidListe(Long id) {
        return cardsDAO.findCardsByListID(id);
    }



    public String deleteCards(Long cardsId) throws CardsNotFoundException {
        // Vérifier si l'cards existe dans la base de données
        Cards existingCards = cardsDAO.findCardsById(cardsId).orElseThrow(
                () -> new CardsNotFoundException("Cards with id " + cardsId + " not found")
        );

        // Supprimer l'cards
        cardsDAO.deleteCards(existingCards);

        return "Cards Successfully deleted";
    }
}
