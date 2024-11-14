package tn.esprit.servicestage.application.dao;

import tn.esprit.servicestage.application.dto.NewStageDto;
import tn.esprit.servicestage.domain.Stage;

import java.util.List;
import java.util.Optional;

public interface StageDAO {
    Optional<Stage> findStageByType(String type);
    List<Stage> findAllStages();
    void saveStage(NewStageDto stage);
    void updateStage(Stage newStage);
    void deleteStage(Stage oldStage);
    Optional<Stage> findStageById(Long stageId);
}
