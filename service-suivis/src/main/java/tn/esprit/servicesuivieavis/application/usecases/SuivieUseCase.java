package tn.esprit.servicesuivieavis.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.servicesuivieavis.application.dao.SuivieDAO;
import tn.esprit.servicesuivieavis.application.dto.NewSuivieDto;
import tn.esprit.servicesuivieavis.domain.Suivie;
import tn.esprit.servicesuivieavis.exceptions.SuivieAlreadyExistsException;
import tn.esprit.servicesuivieavis.exceptions.SuivieNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class SuivieUseCase {
    private final SuivieDAO suivieDAO;

    public String saveSuivie(NewSuivieDto newSuivieDto) throws SuivieAlreadyExistsException {
        // Vérifier si le suivi existe déjà dans la base de données
        var isPresent = suivieDAO.findSuivieById(newSuivieDto.id()).isPresent();
        if (isPresent) {
            throw new SuivieAlreadyExistsException("Suivie already exists");
        }

        // Continuer à enregistrer le suivi
        suivieDAO.saveSuivie(newSuivieDto);

        return "Suivie Saved Successfully";
    }

    public List<Suivie> getAllSuivies() {
        return suivieDAO.findAllSuivies();
    }

    public String updateSuivie(Suivie suivie) throws SuivieNotFoundException {
        // Vérifier si le suivi existe dans la base de données
        var isPresent = suivieDAO.findSuivieById(suivie.id()).isPresent();
        if (!isPresent) {
            throw new SuivieNotFoundException("This suivie does not exist");
        }

        suivieDAO.updateSuivie(suivie);

        return "Suivie Successfully updated";
    }

    public Suivie getSuivieByMotif(String suivieMotif) {
        return suivieDAO.findSuivieByMotif(suivieMotif).orElseThrow(
                () -> new SuivieNotFoundException("This suivie does not exist")
        );
    }

    public Suivie getSuivieById(Long id) {
        return suivieDAO.findSuivieById(id).orElseThrow(
                () -> new SuivieNotFoundException("This suivie does not exist")
        );
    }


    public String deleteSuivie(Long suivieId) throws SuivieNotFoundException {
        // Vérifier si le suivi existe dans la base de données
        Suivie existingSuivie = suivieDAO.findSuivieById(suivieId).orElseThrow(
                () -> new SuivieNotFoundException("Suivie with id " + suivieId + " not found")
        );

        // Supprimer le suivi
        suivieDAO.deleteSuivie(existingSuivie);

        return "Suivie Successfully deleted";
    }
}
