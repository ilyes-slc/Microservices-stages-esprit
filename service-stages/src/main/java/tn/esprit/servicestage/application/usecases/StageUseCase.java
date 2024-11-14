package tn.esprit.servicestage.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.servicestage.application.dao.StageDAO;
import tn.esprit.servicestage.application.dto.NewStageDto;
import tn.esprit.servicestage.domain.Stage;
import tn.esprit.servicestage.exceptions.StageAlreadyExistsException;
import tn.esprit.servicestage.exceptions.StageNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class StageUseCase {
    private final StageDAO stageDAO;

    public String saveStage(NewStageDto newStageDto) throws StageAlreadyExistsException {
        // Check if the stage is already in the database
        var isPresent = stageDAO.findStageByType(newStageDto.type()).isPresent();
        if (isPresent) {
            throw new StageAlreadyExistsException("Stage already exists");
        }

        // Continue to save the stage
        stageDAO.saveStage(newStageDto);

        log.info("Stage saved successfully: {}", newStageDto);

        return "Stage Saved Successfully";
    }

    public List<Stage> getAllStages() {
        return stageDAO.findAllStages();
    }

    public String updateStage(Stage stage) throws StageNotFoundException {
        // Check if the stage exists in the database
        var isPresent = stageDAO.findStageById(stage.id()).isPresent();
        if (!isPresent) {
            throw new StageNotFoundException("This stage does not exist");
        }

        stageDAO.updateStage(stage);

        log.info("Stage updated successfully: {}", stage);

        return "Stage Successfully updated";
    }

    public Stage findStageByType(String stageType) {
        return stageDAO.findStageByType(stageType).orElseThrow(
                () -> new StageNotFoundException("This stage does not exist")
        );
    }

    public Stage findStageById(Long id) {
        return stageDAO.findStageById(id).orElseThrow(
                () -> new StageNotFoundException("This stage does not exist")
        );
    }

    public String deleteStage(Long stageId) throws StageNotFoundException {
        // Check if the stage exists in the database
        Stage existingStage = stageDAO.findStageById(stageId).orElseThrow(
                () -> new StageNotFoundException("Stage with id " + stageId + " not found")
        );

        // Delete the stage
        stageDAO.deleteStage(existingStage);

        log.info("Stage deleted successfully: {}", existingStage);

        return "Stage Successfully deleted";
    }
}
