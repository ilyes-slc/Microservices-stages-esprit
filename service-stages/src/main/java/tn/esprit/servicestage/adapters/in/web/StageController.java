package tn.esprit.servicestage.adapters.in.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.servicestage.application.dto.NewStageDto;
import tn.esprit.servicestage.application.usecases.StageUseCase;
import tn.esprit.servicestage.domain.Stage;
import tn.esprit.servicestage.exceptions.StageAlreadyExistsException;
import tn.esprit.servicestage.exceptions.StageNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/stages")
@RequiredArgsConstructor
public class StageController {

    private final StageUseCase stageUseCase;

    @GetMapping
    public ResponseEntity<List<Stage>> getAllStages() {
        return ResponseEntity.ok(stageUseCase.getAllStages());
    }

    @GetMapping("/test")
    public String test(){
        return "hello";
    }

    @GetMapping("/test2")
    public String test2(){
        return "hiiii";
    }

    @GetMapping("/find/{type}")
    public ResponseEntity<Stage> getStageByType(@PathVariable("type") String type) {
        return ResponseEntity.ok(stageUseCase.findStageByType(type));
    }
    @GetMapping("/{id}")
    public ResponseEntity<Stage> getstageStageById(@PathVariable("id") Long ID) {
        return ResponseEntity.ok(stageUseCase.findStageById(ID));
    }
    @PostMapping
    public NewStageDto saveStage(@RequestBody NewStageDto newStageDto) {
        try {
             stageUseCase.saveStage(newStageDto);
            return newStageDto;
        } catch (StageAlreadyExistsException e) {
            return newStageDto;
        }
    }

    @PutMapping
    public Stage updateStage(@RequestBody Stage stage) {
        try {
             stageUseCase.updateStage(stage);
            return stage;
        } catch (StageNotFoundException e) {
            return stage;
        }
    }

    @DeleteMapping("/{id}")
    public Stage deleteStage(@PathVariable("id") Long id) {
        try {
            Stage d= stageUseCase.findStageById(id);
            stageUseCase.deleteStage(id);
            return d;
        } catch (StageNotFoundException e) {
            Stage d= stageUseCase.findStageById(id);

            return d;
        }
    }
}
