package tn.esprit.servicecards.adapters.out.postgresJDBC.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
public class CardsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private Long board;
    private Long liste;
    private String title;
    private String description;

    public CardsEntity() {
    }
    // Getters
    public Long getId() {return Id;}
    public Long getBoard() {return board;}
    public Long getListID() {return liste;}
    public String getTitle() {
        return title;
    }


    public String getDescription() {
        return description;
    }
}
