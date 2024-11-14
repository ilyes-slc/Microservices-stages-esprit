package tn.esprit.servicestage.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.servicestage.adapters.out.postgresJDBC.entities.StageEntity;
import tn.esprit.servicestage.adapters.out.postgresJDBC.repositories.StagesRepository;
import tn.esprit.servicestage.application.dao.StageDAO;
import tn.esprit.servicestage.application.dto.NewStageDto;
import tn.esprit.servicestage.domain.Stage;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class StageDaoAdapter implements StageDAO {
    private final StagesRepository stagesRepository;

    @Override
    public Optional<Stage> findStageByType(String type) {
        return stagesRepository.findStageByType(type);
    }

    @Override
    public Optional<Stage> findStageById(Long id) {
        return stagesRepository.findStageById(id);
    }

    @Override
    public List<Stage> findAllStages() {
        return ((List<StageEntity>) stagesRepository.findAll()).stream()
                .map(stageEntity -> new Stage(
                        stageEntity.getId(),
                        stageEntity.getDatedebut(),
                        stageEntity.getDatefin(),
                        stageEntity.getType(),
                        stageEntity.getIdEtudiant(),
                        stageEntity.getLien(),
                        stageEntity.getTuteurAcademique(),
                        stageEntity.getEntreprise()
                )).toList();
    }

    @Override
    public void saveStage(NewStageDto stage) {
        StageEntity stageEntity = new StageEntity(
                null,
                stage.datedebut(),
                stage.datefin(),
                stage.type(),
                stage.idEtudiant(),
                stage.lien(),
                stage.tuteurAcademique(),
                stage.entreprise()

        );
        stagesRepository.save(stageEntity);
    }

    @Override
    public void updateStage(Stage newStage) {
        StageEntity stageEntity = new StageEntity(
                newStage.id(),
                newStage.datedebut(),
                newStage.datefin(),
                newStage.type(),
                newStage.idEtudiant(),
                newStage.lien(),
                newStage.tuteurAcademique(),
                newStage.entreprise()

        );
        stagesRepository.save(stageEntity);
    }

    @Override
    public void deleteStage(Stage oldStage) {
        stagesRepository.deleteById(oldStage.id());
    }
}
