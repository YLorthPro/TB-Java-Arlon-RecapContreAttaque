package be.bstorm.formation.recapcontreattaque.dal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class MakerHub {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String sujet;

    private boolean isProjecteurOk;

    private LocalDate dateDePresentation;

    @ManyToOne
    @JoinColumn(name = "personne_id")
    private Personne personne;

}