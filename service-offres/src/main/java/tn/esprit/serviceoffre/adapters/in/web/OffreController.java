package tn.esprit.serviceoffre.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.serviceoffre.application.dto.NewOffreDto;
import tn.esprit.serviceoffre.application.usecases.OffreUseCase;
import tn.esprit.serviceoffre.domain.Offre;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreAlreadyExistsException;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/offres")
@RequiredArgsConstructor
public class OffreController {

    private final OffreUseCase offreUseCase;


    @GetMapping
    public ResponseEntity<List<Offre>> getAllOffres() {
        return ResponseEntity.ok(offreUseCase.getAllOffres());
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hiiii";
    }

    @GetMapping("/find/{title}")
    public ResponseEntity<Offre> getOffreByTitle(@PathVariable("title") String title) {
        return ResponseEntity.ok(offreUseCase.getOffreByTitle(title));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Offre> getOffreById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(offreUseCase.getOffreById(id));
    }

    @PostMapping
    public NewOffreDto saveOffre(@RequestBody NewOffreDto newOffreDto) {
        try {
             offreUseCase.saveOffre(newOffreDto);
            return newOffreDto;
        } catch (OffreAlreadyExistsException e) {
            return newOffreDto;
        }
    }

    @PutMapping
    public Offre updateOffre(@RequestBody Offre offre) {
        try {
             offreUseCase.updateOffre(offre);
            return offre;
        } catch (OffreNotFoundException e) {
            return offre;
        }
    }

    // Implement delete mapping for deleting an Offre
    @DeleteMapping("/{id}")
    public Offre deleteOffre(@PathVariable("id") Long id) {
        try {
            Offre e = offreUseCase.getOffreById(id);
            offreUseCase.deleteOffre(id);
            return  e;
        } catch (OffreNotFoundException e) {
            Offre ee = offreUseCase.getOffreById(id);
            return ee;

        }
    }


}
