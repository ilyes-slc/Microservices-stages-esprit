package tn.esprit.serviceoffre.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.serviceoffre.application.dao.OffreDAO;
import tn.esprit.serviceoffre.application.dto.NewOffreDto;
import tn.esprit.serviceoffre.domain.Offre;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreAlreadyExistsException;
import tn.esprit.serviceoffre.infrastructure.exceptions.OffreNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class OffreUseCase {
    private final OffreDAO offreDAO;

    public String saveOffre(NewOffreDto newOffreDto) throws OffreAlreadyExistsException {
        // Check if the offre is already in the database
        var isPresent = offreDAO.findOffreByTitle(newOffreDto.title()).isPresent();
        if (isPresent) {
            throw new OffreAlreadyExistsException("Offre already exists");
        }

        // Continue to save the offre
        offreDAO.saveOffre(newOffreDto);

        return "Offre Saved Successfully";
    }

    public List<Offre> getAllOffres() {
        return offreDAO.findAllOffres();
    }

    public String updateOffre(Offre offre) throws OffreNotFoundException {
        // Check if the offre exists in the database
        var isPresent = offreDAO.findOffreById(offre.id()).isPresent();
        if (!isPresent) {
            throw new OffreNotFoundException("This offre does not exist");
        }

        offreDAO.updateOffre(offre);

        return "Offre Successfully updated";
    }

    public Offre getOffreByTitle(String offreTitle) {
        return offreDAO.findOffreByTitle(offreTitle).orElseThrow(
                () -> new OffreNotFoundException("This offre does not exist")
        );
    }

    public Offre getOffreById(Long id) {
        return offreDAO.findOffreById(id).orElseThrow(
                () -> new OffreNotFoundException("This offre does not exist")
        );
    }
    public String deleteOffre(Long offreId) throws OffreNotFoundException {
        // Vérifier si l'offre existe dans la base de données
        Offre existingOffre = offreDAO.findOffreById(offreId).orElseThrow(
                () -> new OffreNotFoundException("Offre with id " + offreId + " not found")
        );

        // Supprimer l'offre
        offreDAO.deleteOffre(existingOffre);

        return "Offre Successfully deleted";
    }

}
