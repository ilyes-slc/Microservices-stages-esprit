package tn.esprit.serviceoffre.application.usecases;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tn.esprit.serviceoffre.application.dao.PostulationDAO;
import tn.esprit.serviceoffre.application.dto.NewPostulationDto;
import tn.esprit.serviceoffre.domain.Postulation;
import tn.esprit.serviceoffre.infrastructure.exceptions.PostulationAlreadyExistsException;
import tn.esprit.serviceoffre.infrastructure.exceptions.PostulationNotFoundException;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class PostulationUseCase {
    private final PostulationDAO postulationDAO;

    public String savePostulation(NewPostulationDto newPostulationDto) throws PostulationAlreadyExistsException {
        // Check if the postulation is already in the database
        var isPresent = postulationDAO.findPostulationByIdPostulation(newPostulationDto.idPostulation()).isPresent();
        if (isPresent) {
            throw new PostulationAlreadyExistsException("Postulation already exists");
        }

        // Continue to save the postulation
        postulationDAO.savePostulation(newPostulationDto);

        return "Postulation Saved Successfully";
    }

    public List<Postulation> getAllPostulations() {
        return postulationDAO.findAllPostulations();
    }

    public String updatePostulation(Postulation postulation) throws PostulationNotFoundException {
        // Check if the postulation exists in the database
        var isPresent = postulationDAO.findPostulationByIdPostulation(postulation.idPostulation()).isPresent();
        if (!isPresent) {
            throw new PostulationNotFoundException("This postulation does not exist");
        }

        postulationDAO.updatePostulation(postulation);

        return "Postulation Successfully updated";
    }

    public Postulation getPostulationByIdPostulation(Long idPostulation) throws PostulationNotFoundException {
        return postulationDAO.findPostulationByIdPostulation(idPostulation).orElseThrow(
                () -> new PostulationNotFoundException("This postulation does not exist")
        );
    }

    public Postulation getPostulationById(Long idPostulation) throws PostulationNotFoundException {
        return postulationDAO.findPostulationByIdPostulation(idPostulation).orElseThrow(
                () -> new PostulationNotFoundException("This postulation does not exist")
        );
    }

    public String deletePostulation(Long idPostulation) throws PostulationNotFoundException {
        // Verify if the postulation exists in the database
        Postulation existingPostulation = postulationDAO.findPostulationByIdPostulation(idPostulation).orElseThrow(
                () -> new PostulationNotFoundException("Postulation with id " + idPostulation + " not found")
        );

        // Delete the postulation
        postulationDAO.deletePostulation(existingPostulation);

        return "Postulation Successfully deleted";
    }
}
