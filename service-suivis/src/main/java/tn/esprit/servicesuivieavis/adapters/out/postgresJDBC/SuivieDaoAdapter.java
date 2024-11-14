package tn.esprit.servicesuivieavis.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.servicesuivieavis.adapters.out.postgresJDBC.entities.SuivieEntity;
import tn.esprit.servicesuivieavis.adapters.out.postgresJDBC.repositories.SuiviesRepository;
import tn.esprit.servicesuivieavis.application.dao.SuivieDAO;
import tn.esprit.servicesuivieavis.application.dto.NewSuivieDto;
import tn.esprit.servicesuivieavis.domain.Suivie;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class SuivieDaoAdapter implements SuivieDAO {
    private final SuiviesRepository suivieRepository;

    @Override
    public Optional<Suivie> findSuivieByMotif(String motif) {
        // Implement the method as needed
        return suivieRepository.findSuivieByMotif(motif);
    }

    @Override
    public Optional<Suivie> findSuivieById(Long id) {
        // Implement the method as needed
        return suivieRepository.findSuivieById(id);
    }

    @Override
    public List<Suivie> findAllSuivies() {
        return ((List<SuivieEntity>) suivieRepository.findAll()).stream()
                .map(suivieEntity -> new Suivie(
                        suivieEntity.getId(),
                        suivieEntity.getidIncadrant(),
                        suivieEntity.getidEtudiant(),
                        suivieEntity.getDate(),
                        suivieEntity.getMotif(),
                        suivieEntity.getRessource()
                        // Add other attributes as needed
                )).toList();
    }

    @Override
    public void saveSuivie(NewSuivieDto suivieDto) {
        SuivieEntity suivieEntity = new SuivieEntity(
                null,
                suivieDto.idIncadrant(),
                suivieDto.idEtudiant(),
                suivieDto.date(),
                suivieDto.motif(),
                suivieDto.ressource()
                // Add other attributes as needed
        );
        suivieRepository.save(suivieEntity);
    }

    @Override
    public void updateSuivie(Suivie updatedSuivie) {
        SuivieEntity suivieEntity = new SuivieEntity(
                updatedSuivie.id(),
                updatedSuivie.idIncadrant(),
                updatedSuivie.idEtudiant(),
                updatedSuivie.date(),
                updatedSuivie.motif(),
                updatedSuivie.ressource()
                // Add other attributes as needed
        );
        suivieRepository.save(suivieEntity);
    }

    @Override
    public void deleteSuivie(Suivie suivieId) {
        suivieRepository.deleteById(suivieId.id());
    }
}
