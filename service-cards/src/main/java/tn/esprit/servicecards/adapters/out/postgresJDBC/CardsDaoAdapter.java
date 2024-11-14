package tn.esprit.servicecards.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.servicecards.adapters.out.postgresJDBC.entities.CardsEntity;
import tn.esprit.servicecards.adapters.out.postgresJDBC.repositories.CardsRepository;
import tn.esprit.servicecards.application.dao.CardsDAO;
import tn.esprit.servicecards.application.dto.NewCardsDto;
import tn.esprit.servicecards.domain.Cards;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class CardsDaoAdapter implements CardsDAO {
    private final CardsRepository cardsRepository;




    @Override
    public Optional<Cards> findCardsById(Long id) {
        return cardsRepository.findCardsById(id);
    }

    @Override
    public List<Cards> findCardsByListID(Long id) {
        return cardsRepository.findCardsByliste(id);
    }


    @Override
    public List<Cards> findAllCards() {
        return ((List<CardsEntity>) cardsRepository.findAll()).stream()
                .map(cardsEntity -> new Cards(
                        cardsEntity.getId(),
                        cardsEntity.getBoard(),
                        cardsEntity.getListID(),
                        cardsEntity.getTitle(),
                        cardsEntity.getDescription()
                )).toList();
    }

    @Override
    public void saveCards(NewCardsDto cards) {
        CardsEntity cardsEntity = new CardsEntity(
                null,
                cards.board(),
                cards.liste(),
                cards.title(),
                cards.description()
        );
        cardsRepository.save(cardsEntity);
    }

    @Override
    public void updateCards(Cards newCards) {
        CardsEntity cardsEntity = new CardsEntity(
                newCards.id(),
                newCards.board(),
                newCards.liste(),
                newCards.title(),
                newCards.description()

        );
        cardsRepository.save(cardsEntity);
    }

    @Override
    public void deleteCards(Cards oldCards) {
        cardsRepository.deleteById(oldCards.id());
    }
}
