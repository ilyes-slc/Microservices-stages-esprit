package tn.esprit.servicesignature.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.servicesignature.adapters.out.postgresJDBC.entities.SignatureEntity;
import tn.esprit.servicesignature.domain.Signature;

import java.util.Optional;

@Repository
public interface SingaturesRepository extends CrudRepository<SignatureEntity, Long> {
    Optional<Signature> findSignatureByNom(String nom);
    Optional<Signature> findSignatureById(Long id);

}
