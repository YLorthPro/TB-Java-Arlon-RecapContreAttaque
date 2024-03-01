package be.bstorm.formation.recapcontreattaque.dal.repositories;

import be.bstorm.formation.recapcontreattaque.dal.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}