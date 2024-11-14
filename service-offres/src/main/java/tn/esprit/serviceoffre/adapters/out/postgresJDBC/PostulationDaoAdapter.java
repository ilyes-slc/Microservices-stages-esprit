package tn.esprit.serviceoffre.adapters.out.postgresJDBC;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities.PostulationEntity;
import tn.esprit.serviceoffre.adapters.out.postgresJDBC.repositories.PostulationRepository;
import tn.esprit.serviceoffre.application.dao.PostulationDAO;
import tn.esprit.serviceoffre.application.dto.NewPostulationDto;
import tn.esprit.serviceoffre.domain.Postulation;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class PostulationDaoAdapter implements PostulationDAO {
    private final PostulationRepository postulationsRepository;
    @Override
    public Optional<Postulation> findPostulationByIdPostulation(Long idPostulation) {
        return postulationsRepository.findPostulationByIdPostulation(idPostulation);
    }

    @Override
    public List<Postulation> findAllPostulations() {
        return ((List<PostulationEntity>) postulationsRepository.findAll()).stream()
                .map(entity -> new Postulation(
                        entity.getIdPostulation(),
                        entity.getIdOffre(),
                        entity.getIdUser(),
                        entity.getDatePostulation(),
                        entity.getCv(),
                        entity.getLettreMotivation(),
                        entity.getEtatPostulation()
                )).toList();
    }

    @Override
    public void savePostulation(NewPostulationDto postulation) {
        PostulationEntity postulationEntity = new PostulationEntity(
                null,
                postulation.idOffre(),
                postulation.idUser(),
                postulation.datePostulation(),
                postulation.cv(),
                postulation.lettreMotivation(),
                postulation.etatPostulation(),0
        );
        postulationsRepository.save(postulationEntity);
    }

    @Override
    public void updatePostulation(Postulation newPostulation) {
        PostulationEntity postulationEntity = new PostulationEntity(
                newPostulation.idPostulation(),
                newPostulation.idOffre(),
                newPostulation.idUser(),
                newPostulation.datePostulation(),
                newPostulation.cv(),
                newPostulation.lettreMotivation(),
                newPostulation.etatPostulation(),0
        );
        postulationsRepository.save(postulationEntity);
    }

    @Override
    public void deletePostulation(Postulation oldPostulation) {
        postulationsRepository.deleteById(oldPostulation.idPostulation());
    }
}
