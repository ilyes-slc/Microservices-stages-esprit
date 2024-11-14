package tn.esprit.serviceoffre.application.dao;
import tn.esprit.serviceoffre.application.dto.NewPostulationDto;
import tn.esprit.serviceoffre.domain.Postulation;

import java.util.List;
import java.util.Optional;

public interface PostulationDAO {

        Optional<Postulation> findPostulationByIdPostulation(Long idPostulation);
        List<Postulation> findAllPostulations();
        void savePostulation(NewPostulationDto postulation);
        void updatePostulation(Postulation newPostulation);
        void deletePostulation(Postulation oldPostulation);
    }


