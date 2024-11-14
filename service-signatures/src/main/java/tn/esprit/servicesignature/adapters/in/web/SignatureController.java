package tn.esprit.servicesignature.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicesignature.application.dto.NewSignatureDto;
import tn.esprit.servicesignature.application.usecases.SignatureUseCase;
import tn.esprit.servicesignature.domain.Signature;
import tn.esprit.servicesignature.exceptions.SignatureAlreadyExistsException;
import tn.esprit.servicesignature.exceptions.SignatureNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/signatures")
@RequiredArgsConstructor
public class SignatureController {

    private final SignatureUseCase signatureUseCase;

    @GetMapping
    public ResponseEntity<List<Signature>> getAllSignatures() {
        return ResponseEntity.ok(signatureUseCase.getAllSignatures());
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hiiii";
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Signature> getSignatureById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(signatureUseCase.findSignatureById(id));
    }

    @PostMapping
    public ResponseEntity<?> saveSignature(@RequestBody NewSignatureDto newSignatureDto) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(signatureUseCase.saveSignature(newSignatureDto));
        } catch (SignatureAlreadyExistsException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

    @PutMapping
    public ResponseEntity<?> updateSignature(@RequestBody Signature signature) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(signatureUseCase.updateSignature(signature));
        } catch (SignatureNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteSignature(@PathVariable("id") Long id) {
        try {
            signatureUseCase.deleteSignature(id);
            return ResponseEntity.status(HttpStatus.OK).body("Signature Successfully deleted");
        } catch (SignatureNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }
}
