package tn.esprit.serviceoffre.adapters.out.postgresJDBC.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.OffreEntity;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.PostulationEntity;
import tn.esprit.serviceoffre.domain.Offre;
import tn.esprit.serviceoffre.domain.Postulation;

import java.util.Optional;

@Repository
public interface PostulationRepository extends CrudRepository <PostulationEntity,Long>
{
    Optional<Postulation> findPostulationByIdPostulation(Long idPostulation);
    Optional<Postulation> getPostulationByidOffre(Long idOffre);
}
