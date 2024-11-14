package tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Version;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
public class PostulationEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long idPostulation;
        private Long idOffre;
        private Long idUser;
        private LocalDate datePostulation;
        private String cv;
        private String lettreMotivation;
        private String etatPostulation;

        @Version
        private Integer version;

    public PostulationEntity() {

    }

    public Long getIdPostulation() {
        return idPostulation;
    }
    public void setIdPostulation(Long idPostulation) {
        this.idPostulation = idPostulation;
    }

    public Long getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(Long idOffre) {
        this.idOffre = idOffre;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public LocalDate getDatePostulation() {
        return datePostulation;
    }

    public void setDatePostulation(LocalDate datePostulation) {
        this.datePostulation = datePostulation;
    }

    public String getCv() {
        return cv;
    }

    public void setCv(String cv) {
        this.cv = cv;
    }

    public String getLettreMotivation() {
        return lettreMotivation;
    }

    public void setLettreMotivation(String lettreMotivation) {
        this.lettreMotivation = lettreMotivation;
    }

    public String getEtatPostulation() {
        return etatPostulation;
    }

    public void setEtatPostulation(String etatPostulation) {
        this.etatPostulation = etatPostulation;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

}

