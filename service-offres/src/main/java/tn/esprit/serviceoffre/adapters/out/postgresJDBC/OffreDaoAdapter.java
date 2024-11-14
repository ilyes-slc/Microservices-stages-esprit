package tn.esprit.serviceoffre.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.OffreEntity;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.repositories.OffresRepository;
import tn.esprit.serviceoffre.application.dao.OffreDAO;
import tn.esprit.serviceoffre.application.dto.NewOffreDto;
import tn.esprit.serviceoffre.domain.Offre;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@RequiredArgsConstructor
@Component
public class OffreDaoAdapter implements OffreDAO {
    private final OffresRepository offresRepository;



    @Override
    public Optional<Offre> findOffreByTitle(String title) {
        return offresRepository.findOffreByTitle(title);
    }
    @Override
    public Optional<Offre> findOffreById(Long id) {
        return offresRepository.findOffreById(id);
    }

    @Override
    public List<Offre> findAllOffres() {
        return ((List<OffreEntity>) offresRepository.findAll()).stream()
                .map(offreEntity -> new Offre(
                        offreEntity.getId(),
                        offreEntity.getDate(),
                        offreEntity.getTitle(),
                        offreEntity.getIdEntreprise(),
                        offreEntity.getDescription(),
                        offreEntity.getLocation(),
                        offreEntity.getRemote(),
                        offreEntity.isEasyApply()
                )).toList();
    }

    @Override
    public void saveOffre(NewOffreDto offre) {
        OffreEntity offreEntity = new OffreEntity(
                null,
                offre.date(),
                offre.title(),
                offre.idEntreprise(),
                offre.description(),
                offre.location(),
                offre.remote(),
                offre.easyApply(),
                null
        );
        offresRepository.save(offreEntity);
    }

    @Override
    public void updateOffre(Offre newOffre) {
        OffreEntity offreEntity = new OffreEntity(
                newOffre.id(),
                newOffre.date(),
                newOffre.title(),
                newOffre.idEntreprise(),
                newOffre.description(),
                newOffre.location(),
                newOffre.remote(),
                newOffre.easyApply(),
                null
        );
        offresRepository.save(offreEntity);
    }

    @Override
    public void deleteOffre(Offre oldOffre) {
        offresRepository.deleteById(oldOffre.id());
    }
}
