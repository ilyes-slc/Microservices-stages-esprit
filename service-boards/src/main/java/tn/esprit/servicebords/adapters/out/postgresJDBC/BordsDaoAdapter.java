package tn.esprit.servicebords.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.servicebords.adapters.out.postgresJDBC.entities.BordsEntity;
import tn.esprit.servicebords.adapters.out.postgresJDBC.repositories.BordsRepository;

import tn.esprit.servicebords.application.dao.BordsDAO;
import tn.esprit.servicebords.application.dto.NewBordsDto;
import tn.esprit.servicebords.domain.Bords;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Component
public class BordsDaoAdapter implements BordsDAO {
    private final BordsRepository bordsRepository;



    @Override
    public Optional<Bords> findBordsByTitle(String title) {
        return bordsRepository.findBordsByTitle(title);
    }
    @Override
    public Optional<Bords> findBordsById(Long id) {
        return bordsRepository.findBordsById(id);
    }

    @Override
    public List<Bords> findAllBordss() {
        return ((List<BordsEntity>) bordsRepository.findAll()).stream()
                .map(bordsEntity -> new Bords(
                        bordsEntity.getId(),
                        bordsEntity.getTitle(),
                        bordsEntity.getDescription()
                )).toList();
    }

    @Override
    public void saveBords(NewBordsDto bords) {
        BordsEntity bordsEntity = new BordsEntity(
                null,
                bords.title(),
                bords.description()
        );
        bordsRepository.save(bordsEntity);
    }

    @Override
    public void updateBords(Bords newBords) {
        BordsEntity bordsEntity = new BordsEntity(
                newBords.id(),
                newBords.title(),
                newBords.description()

        );
        bordsRepository.save(bordsEntity);
    }

    @Override
    public void deleteBords(Bords oldBords) {
        bordsRepository.deleteById(oldBords.id());
    }
}
