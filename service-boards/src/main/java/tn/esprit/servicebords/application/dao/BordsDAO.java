package tn.esprit.servicebords.application.dao;

import tn.esprit.servicebords.application.dto.NewBordsDto;
import tn.esprit.servicebords.domain.Bords;

import java.util.List;
import java.util.Optional;

public interface BordsDAO {
    Optional<Bords> findBordsByTitle(String title);
    List<Bords> findAllBordss();
    void saveBords(NewBordsDto offre);
    void updateBords(Bords newBords);
    void deleteBords(Bords oldBords);
    Optional<Bords> findBordsById(Long offreId);
}
