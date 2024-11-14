package tn.esprit.servicesignature.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.servicesignature.adapters.out.postgresJDBC.entities.SignatureEntity;
import tn.esprit.servicesignature.adapters.out.postgresJDBC.repositories.SingaturesRepository;
import tn.esprit.servicesignature.application.dao.SignatureDAO;
import tn.esprit.servicesignature.application.dto.NewSignatureDto;
import tn.esprit.servicesignature.domain.Signature;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SignatureDaoAdapter implements SignatureDAO {
    private final SingaturesRepository signatureRepository;

    @Override
    public Optional<Signature> findSignatureByNom(String nom) {
        return signatureRepository.findSignatureByNom(nom);
    }

    @Override
    public Optional<Signature> findSignatureById(Long id) {
        return signatureRepository.findSignatureById(id);
    }

    @Override
    public List<Signature> findAllSignatures() {
        return ((List<SignatureEntity>) signatureRepository.findAll()).stream()
                .map(signatureEntity -> new Signature(
                        signatureEntity.getId(),
                        signatureEntity.getNom(),
                        signatureEntity.getEmail(),
                        signatureEntity.getClepublique(),
                        signatureEntity.getAlgo(),
                        signatureEntity.getDatevalide(),
                        signatureEntity.getEtat()
                )).toList();
    }

    @Override
    public void saveSignature(NewSignatureDto signature) {
        SignatureEntity signatureEntity = new SignatureEntity(
                null,
                signature.nom(),
                signature.email(),
                signature.clepublique(),
                signature.algo(),
                signature.datevalide(),
                signature.etat()
        );
        signatureRepository.save(signatureEntity);
    }

    @Override
    public void updateSignature(Signature newSignature) {
        SignatureEntity signatureEntity = new SignatureEntity(
                newSignature.id(),
                newSignature.nom(),
                newSignature.email(),
                newSignature.clepublique(),
                newSignature.algo(),
                newSignature.datevalide(),
                newSignature.etat()
        );
        signatureRepository.save(signatureEntity);
    }

    @Override
    public void deleteSignature(Signature oldSignature) {
        signatureRepository.deleteById(oldSignature.id());
    }
}
