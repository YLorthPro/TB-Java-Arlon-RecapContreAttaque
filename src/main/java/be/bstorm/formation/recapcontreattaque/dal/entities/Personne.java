package be.bstorm.formation.recapcontreattaque.dal.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Personne {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private String nom;

    @OneToMany(mappedBy = "personne", orphanRemoval = true)
    private List<MakerHub> makerHubs = new ArrayList<>();
    
}
