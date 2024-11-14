package tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Version;
import java.time.LocalDate;

@Entity
@AllArgsConstructor
public class OffreEntity {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private LocalDate date;
        private String title;
        private Long idEntreprise;
        private String description;
        private String location;
        private String remote;
        private boolean easyApply;
        @Version
        private Integer version;

        // Constructor
        public OffreEntity() {
        }


        // Getters
        public Long getId() {
                return id;
        }

        public LocalDate getDate() {
                return date;
        }

        public String getTitle() {
                return title;
        }

        public Long getIdEntreprise() {
                return idEntreprise;
        }

        public String getDescription() {
                return description;
        }

        public String getLocation() {
                return location;
        }

        public String getRemote() {
                return remote;
        }

        public boolean isEasyApply() {
                return easyApply;
        }

        public Integer getVersion() {
                return version;
        }

        // Setters
        public void setId(Long id) {
                this.id = id;
        }

        public void setDate(LocalDate date) {
                this.date = date;
        }

        public void setTitle(String title) {
                this.title = title;
        }

        public void setIdEntreprise(Long idEntreprise) {
                this.idEntreprise = idEntreprise;
        }

        public void setDescription(String description) {
                this.description = description;
        }

        public void setLocation(String location) {
                this.location = location;
        }

        public void setRemote(String remote) {
                this.remote = remote;
        }

        public void setEasyApply(boolean easyApply) {
                this.easyApply = easyApply;
        }

        public void setVersion(Integer version) {
                this.version = version;
        }
}
