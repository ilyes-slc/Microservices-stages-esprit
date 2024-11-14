package tn.esprit.servicesuivieavis.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicesuivieavis.application.dto.NewSuivieDto;
import tn.esprit.servicesuivieavis.application.usecases.SuivieUseCase;
import tn.esprit.servicesuivieavis.domain.Suivie;
import tn.esprit.servicesuivieavis.exceptions.SuivieAlreadyExistsException;
import tn.esprit.servicesuivieavis.exceptions.SuivieNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/suivies")
@RequiredArgsConstructor
public class SuivieController {

    private final SuivieUseCase suivieUseCase;

    @GetMapping
    public ResponseEntity<List<Suivie>> getAllSuivies() {
        return ResponseEntity.ok(suivieUseCase.getAllSuivies());
    }

    @GetMapping("/find/{nom}")
    public ResponseEntity<Suivie> getSuivieByMotif(@PathVariable("motif") String motif) {
        return ResponseEntity.ok(suivieUseCase.getSuivieByMotif(motif));
    }
    @GetMapping("/{id}")
    public Suivie getSuivieByMotif(@PathVariable("id") Long id) {
        return suivieUseCase.getSuivieById(id);
    }

    @PostMapping
    public NewSuivieDto saveSuivie(@RequestBody NewSuivieDto newSuivieDto) {
        try {
             suivieUseCase.saveSuivie(newSuivieDto);
            return newSuivieDto;
        } catch (SuivieAlreadyExistsException e) {
            return newSuivieDto;
        }
    }

    @PutMapping
    public Suivie updateSuivie(@RequestBody Suivie suivie) {
        try {
             suivieUseCase.updateSuivie(suivie);
            return suivie;
        } catch (SuivieNotFoundException e) {
            return suivie;
        }
    }

    @DeleteMapping("/{id}")
    public Suivie deleteSuivie(@PathVariable("id") Long id) {
        try {
            Suivie s = suivieUseCase.getSuivieById(id);
            suivieUseCase.deleteSuivie(id);
            return s;
        } catch (SuivieNotFoundException e) {
            Suivie s = suivieUseCase.getSuivieById(id);

            return s;
        }
    }
}
