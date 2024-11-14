package tn.esprit.servicebords.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.servicebords.adapters.out.postgresJDBC.entities.BordsEntity;
import tn.esprit.servicebords.domain.Bords;

import java.util.Optional;

public interface BordsRepository extends CrudRepository<BordsEntity,Long> {
    Optional<Bords> findBordsByTitle(String title);
    Optional<Bords> findBordsById(Long id);
}




