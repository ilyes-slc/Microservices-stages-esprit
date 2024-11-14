package tn.esprit.servicestage.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
public class StageEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate datedebut;
    private LocalDate datefin;
    private String type;
    private Long idEtudiant;
    private String lien;
    private String tuteurAcademique;
    private String entreprise;

    // Constructors
    public StageEntity() {
    }

    // Getters
    public Long getId() {
        return id;
    }

    public LocalDate getDatedebut() {
        return datedebut;
    }

    public LocalDate getDatefin() {
        return datefin;
    }

    public String getType() {
        return type;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public String getLien() {
        return lien;
    }

    public String getTuteurAcademique() {
        return tuteurAcademique;
    }

    public String getEntreprise() {
        return entreprise;
    }



    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDatedebut(LocalDate datedebut) {
        this.datedebut = datedebut;
    }

    public void setDatefin(LocalDate datefin) {
        this.datefin = datefin;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setLien(String lien) {
        this.lien = lien;
    }

    public void setTuteurAcademique(String tuteurAcademique) {
        this.tuteurAcademique = tuteurAcademique;
    }

    public void setEntreprise(String entreprise) {
        this.entreprise = entreprise;
    }


}
