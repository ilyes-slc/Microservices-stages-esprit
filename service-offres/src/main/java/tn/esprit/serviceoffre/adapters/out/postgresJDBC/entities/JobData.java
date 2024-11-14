package tn.esprit.serviceoffre.adapters.out.postgresJDBC.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JobData {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String jobTitle;
    private String companyName;
    private String location;
    private String method; // e.g., Full-Time, Part-Time

    @Column(columnDefinition="TEXT")
    private String jobDescription;

    @Override
    public String toString() {
        return "JobData{" +
                "id=" + id +
                ", jobTitle='" + jobTitle + '\'' +
                ", companyName='" + companyName + '\'' +
                ", location='" + location + '\'' +
                ", method='" + method + '\'' +
                ", jobDescription='" + jobDescription + '\'' +
                '}';
    }

    // Constructors, Getters, and Setters
}