package tn.esprit.servicebords.adapters.in.web;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicebords.application.dto.NewBordsDto;
import tn.esprit.servicebords.application.usecases.BordsUseCase;
import tn.esprit.servicebords.domain.Bords;
import tn.esprit.servicebords.exceptions.BordsAlreadyExistsException;
import tn.esprit.servicebords.exceptions.BordsNotFoundException;

import java.time.LocalDate;
import java.util.List;
@RestController
@RequestMapping("/bordss")
@RequiredArgsConstructor
public class BordsController {

        private final BordsUseCase bordsUseCase;


        @GetMapping
        public ResponseEntity<List<Bords>> getAllBords() {
            return ResponseEntity.ok(bordsUseCase.getAllBords());
        }

        @GetMapping("/test3")
        public String test(){
            return "hello";
        }

        @GetMapping("/test2")
        public String test2(){
            return "hiiii";
        }

        @GetMapping("/find/{title}")
        public ResponseEntity<Bords> getBordsByTitle(@PathVariable("title") String title) {
            return ResponseEntity.ok(bordsUseCase.getBordsByTitle(title));
        }

        @GetMapping("/{id}")
        public ResponseEntity<Bords> getBordsByid(@PathVariable("id") Long id) {
            return ResponseEntity.ok(bordsUseCase.getBordsByid(id) );
        }

        @PostMapping
        public ResponseEntity<?> saveBords(@RequestBody NewBordsDto newBordsDto) {
            try {
                return ResponseEntity.status(HttpStatus.CREATED).body(bordsUseCase.saveBords(newBordsDto));
            } catch (BordsAlreadyExistsException e) {
                return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
            }
        }

        @PutMapping
        public ResponseEntity<?> updateBords(@RequestBody Bords bords) {
            try {
                return ResponseEntity.status(HttpStatus.OK).body(bordsUseCase.updateBords(bords));
            } catch (BordsNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
            }
        }

        // Implement delete mapping for deleting an Bords
        @DeleteMapping("/{id}")
        public ResponseEntity<?> deleteBords(@PathVariable("id") Long id) {
            try {
                bordsUseCase.deleteBords(id);
                return ResponseEntity.status(HttpStatus.OK).body("Bords Successfully deleted");
            } catch (BordsNotFoundException e) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());

            }
        }

}
