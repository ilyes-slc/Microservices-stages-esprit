package tn.esprit.servicesignature.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
public class SignatureEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nom;
    private String email;
    private Long clepublique;
    private String algo;
    private LocalDate datevalide;
    private String etat;

    // Constructors
    public SignatureEntity() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getEmail() {
        return email;
    }

    public Long getClepublique() {
        return clepublique;
    }

    public String getAlgo() {
        return algo;
    }

    public LocalDate getDatevalide() {
        return datevalide;
    }

    public String getEtat() {
        return etat;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClepublique(Long clepublique) {
        this.clepublique = clepublique;
    }

    public void setAlgo(String algo) {
        this.algo = algo;
    }

    public void setDatevalide(LocalDate datevalide) {
        this.datevalide = datevalide;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }
}
