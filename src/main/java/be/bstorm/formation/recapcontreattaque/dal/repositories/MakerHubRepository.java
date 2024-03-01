package be.bstorm.formation.recapcontreattaque.dal.repositories;

import be.bstorm.formation.recapcontreattaque.dal.entities.MakerHub;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MakerHubRepository extends JpaRepository<MakerHub, Long> {
}