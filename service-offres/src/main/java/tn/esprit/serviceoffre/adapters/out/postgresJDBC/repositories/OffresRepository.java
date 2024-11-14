package tn.esprit.serviceoffre.adapters.out.postgresJDBC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.OffreEntity;
import tn.esprit.serviceoffre.domain.Offre;

import java.util.Optional;

@Repository
public interface OffresRepository extends CrudRepository<OffreEntity,Long> {
    //Optional<Offre> findOffreByTitle(@Param("title") String title);
    Optional<Offre> findOffreByTitle(String title);
    Optional<Offre> findOffreById(Long id);
}