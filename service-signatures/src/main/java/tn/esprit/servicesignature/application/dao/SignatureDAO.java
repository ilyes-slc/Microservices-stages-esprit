package tn.esprit.servicesignature.application.dao;

import tn.esprit.servicesignature.application.dto.NewSignatureDto;
import tn.esprit.servicesignature.domain.Signature;

import java.util.List;
import java.util.Optional;

public interface SignatureDAO {
    Optional<Signature> findSignatureByNom(String nom);
    List<Signature> findAllSignatures();
    void saveSignature(NewSignatureDto signatureDto);
    void updateSignature(Signature signature);
    void deleteSignature(Signature signature);
    Optional<Signature> findSignatureById(Long signatureId);
}
