package tn.esprit.servicesignature.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.servicesignature.application.dao.SignatureDAO;
import tn.esprit.servicesignature.application.dto.NewSignatureDto;
import tn.esprit.servicesignature.domain.Signature;
import tn.esprit.servicesignature.exceptions.SignatureAlreadyExistsException;
import tn.esprit.servicesignature.exceptions.SignatureNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SignatureUseCase {
    private final SignatureDAO signatureDAO;

    public String saveSignature(NewSignatureDto newSignatureDto) throws SignatureAlreadyExistsException {
        // Check if the signature is already in the database
        var isPresent = signatureDAO.findSignatureById(newSignatureDto.id()).isPresent();
        if (isPresent) {
            throw new SignatureAlreadyExistsException("Signature already exists");
        }

        // Continue to save the signature
        signatureDAO.saveSignature(newSignatureDto);

        log.info("Signature saved successfully: {}", newSignatureDto);

        return "Signature Saved Successfully";
    }

    public List<Signature> getAllSignatures() {
        return signatureDAO.findAllSignatures();
    }

    public String updateSignature(Signature signature) throws SignatureNotFoundException {
        // Check if the signature exists in the database
        var isPresent = signatureDAO.findSignatureById(signature.id()).isPresent();
        if (!isPresent) {
            throw new SignatureNotFoundException("This signature does not exist");
        }

        signatureDAO.updateSignature(signature);

        log.info("Signature updated successfully: {}", signature);

        return "Signature Successfully updated";
    }

    public Signature findSignatureById(Long signatureId) {
        return signatureDAO.findSignatureById(signatureId).orElseThrow(
                () -> new SignatureNotFoundException("This signature does not exist")
        );
    }

    public String deleteSignature(Long signatureId) throws SignatureNotFoundException {
        // Check if the signature exists in the database
        Signature existingSignature = signatureDAO.findSignatureById(signatureId).orElseThrow(
                () -> new SignatureNotFoundException("Signature with id " + signatureId + " not found")
        );

        // Delete the signature
        signatureDAO.deleteSignature(existingSignature);

        log.info("Signature deleted successfully: {}", existingSignature);

        return "Signature Successfully deleted";
    }
}
