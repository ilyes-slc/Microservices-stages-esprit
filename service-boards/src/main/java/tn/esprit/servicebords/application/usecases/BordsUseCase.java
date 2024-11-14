package tn.esprit.servicebords.application.usecases;
import tn.esprit.servicebords.application.dao.BordsDAO;
import tn.esprit.servicebords.application.dto.NewBordsDto;
import tn.esprit.servicebords.domain.Bords;
import tn.esprit.servicebords.exceptions.BordsAlreadyExistsException;
import tn.esprit.servicebords.exceptions.BordsNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class BordsUseCase {
    private final BordsDAO bordsDAO;

    public String saveBords(NewBordsDto newBordsDto) throws BordsAlreadyExistsException {
        // Check if the bords is already in the database
        var isPresent = bordsDAO.findBordsByTitle(newBordsDto.title()).isPresent();
        if (isPresent) {
            throw new BordsAlreadyExistsException("Bords already exists");
        }

        // Continue to save the bords
        bordsDAO.saveBords(newBordsDto);

        return "Bords Saved Successfully";
    }

    public List<Bords> getAllBords() {
        return bordsDAO.findAllBordss();
    }

    public String updateBords(Bords bords) throws BordsNotFoundException {
        // Check if the bords exists in the database
        var isPresent = bordsDAO.findBordsById(bords.id()).isPresent();
        if (!isPresent) {
            throw new BordsNotFoundException("This bords does not exist");
        }

        bordsDAO.updateBords(bords);

        return "Bords Successfully updated";
    }

    public Bords getBordsByTitle(String bordsTitle) {
        return bordsDAO.findBordsByTitle(bordsTitle).orElseThrow(
                () -> new BordsNotFoundException("This bords does not exist")
        );
    }

    public Bords getBordsByid(Long id) {
        return bordsDAO.findBordsById(id).orElseThrow(
                () -> new BordsNotFoundException("This bords does not exist")
        );
    }
    public String deleteBords(Long bordsId) throws BordsNotFoundException {
        // Vérifier si l'bords existe dans la base de données
        Bords existingBords = bordsDAO.findBordsById(bordsId).orElseThrow(
                () -> new BordsNotFoundException("Bords with id " + bordsId + " not found")
        );

        // Supprimer l'bords
        bordsDAO.deleteBords(existingBords);

        return "Bords Successfully deleted";
    }
}
