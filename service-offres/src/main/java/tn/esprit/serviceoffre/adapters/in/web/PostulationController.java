package tn.esprit.serviceoffre.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.serviceoffre.application.dto.NewOffreDto;
import tn.esprit.serviceoffre.application.dto.NewPostulationDto;
import tn.esprit.serviceoffre.application.usecases.OffreUseCase;
import tn.esprit.serviceoffre.application.usecases.PostulationUseCase;
import tn.esprit.serviceoffre.domain.Offre;
import tn.esprit.serviceoffre.domain.Postulation;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreAlreadyExistsException;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreNotFoundException;
import tn.esprit.serviceoffre.infrastructure.exceptions.PostulationAlreadyExistsException;
import tn.esprit.serviceoffre.infrastructure.exceptions.PostulationNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/postulations")

public class PostulationController {

    private final PostulationUseCase postulationUseCase;

    public PostulationController(PostulationUseCase postulationUseCase) {
        this.postulationUseCase = postulationUseCase;
    }

    @GetMapping
    public ResponseEntity<List<Postulation>> getAllPostulations() {
        return ResponseEntity.ok(postulationUseCase.getAllPostulations());
    }

    @GetMapping("/test11")
    public String test(){
        return "hello";
    }

    @GetMapping("/test22")
    public String test2(){
        return "hiiii";
    }

    @GetMapping("/find/{idpostulation}")
    public ResponseEntity<Postulation> getPostulationByidPostulation(@PathVariable("idpostulation") Long idPostulation) {
        return ResponseEntity.ok(postulationUseCase.getPostulationByIdPostulation(idPostulation));
    }

    @PostMapping
    public ResponseEntity<?> savePostulation(@RequestBody NewPostulationDto newPostulationDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(postulationUseCase.savePostulation(newPostulationDto));
        } catch (PostulationAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePostulation(@RequestBody Postulation postulation) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(postulationUseCase.updatePostulation(postulation));
        } catch (PostulationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{idpostulation}")
    public ResponseEntity<?> deletePostulation(@PathVariable("idpostulation") Long idPostulation) {
        try {
            postulationUseCase.deletePostulation(idPostulation);
            return ResponseEntity.status(HttpStatus.OK).body("Postulation Successfully deleted");
        } catch (PostulationNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

        }
    }

}
