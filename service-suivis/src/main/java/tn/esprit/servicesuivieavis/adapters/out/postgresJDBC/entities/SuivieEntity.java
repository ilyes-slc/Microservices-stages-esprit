package tn.esprit.servicesuivieavis.adapters.out.postgresJDBC.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
public class SuivieEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long idIncadrant;
    private Long idEtudiant;
    private Date date;
    private String motif;
    private String ressource;

    public SuivieEntity (){
    }


    public Long getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getMotif() {
        return motif;
    }

    public Long getidEtudiant() {
        return idEtudiant;
    }

    public Long getidIncadrant() {
        return idIncadrant;
    }

    public String getRessource() {
        return ressource;
    }





    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setMotif(String Motif) {
        this.motif = motif;
    }

    public void setIdIncadrant(Long IdIncadrant) {
        this.idIncadrant = idIncadrant;
    }

    public void setIdEtudiant(Long IdEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public void setRessource(String Ressource) {
        this.ressource = ressource;
    }





    }
