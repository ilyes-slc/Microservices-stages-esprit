package tn.esprit.servicecards.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicecards.application.dto.NewCardsDto;
import tn.esprit.servicecards.application.usecases.CardsUseCase;
import tn.esprit.servicecards.domain.Cards;
import tn.esprit.servicecards.exceptions.CardsAlreadyExistsException;
import tn.esprit.servicecards.exceptions.CardsNotFoundException;

import java.util.List;
@RestController
@RequestMapping("/cards")
@RequiredArgsConstructor
public class CardsController {

    private final CardsUseCase cardsUseCase;


    @GetMapping
    public ResponseEntity<List<Cards>> getAllCards() {
        return ResponseEntity.ok(cardsUseCase.getAllCards());
    }

    @GetMapping("/test3")
    public String test(){
        return "hello";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hiiii";
    }




    @PostMapping
    public ResponseEntity<?> saveCards(@RequestBody NewCardsDto newCardsDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(cardsUseCase.saveCards(newCardsDto));
        } catch (CardsAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cards> getBordsByid(@PathVariable("id") Long id) {
        return ResponseEntity.ok(cardsUseCase.getCardsByid(id) );
    }

    @GetMapping("/liste/{id}")
    public List<Cards> getBordsBylisteid(@PathVariable("id") Long id) {
        return cardsUseCase.getCardsByidListe(id);
    }
    @PutMapping
    public ResponseEntity<?> updateCards(@RequestBody Cards cards) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(cardsUseCase.updateCards(cards));
        } catch (CardsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    // Implement delete mapping for deleting an Cards
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCards(@PathVariable("id") Long id) {
        try {
            cardsUseCase.deleteCards(id);
            return ResponseEntity.status(HttpStatus.OK).body("Cards Successfully deleted");
        } catch (CardsNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

}
