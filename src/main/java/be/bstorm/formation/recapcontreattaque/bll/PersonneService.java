package be.bstorm.formation.recapcontreattaque.bll;

import be.bstorm.formation.recapcontreattaque.api.models.forms.PersonneFrom;
import be.bstorm.formation.recapcontreattaque.dal.entities.Personne;

import java.util.List;
import java.util.Optional;

public interface PersonneService {
    Optional<Personne> getOne(Long id);
    List<Personne> getAll();
    void create(PersonneFrom form);
    void update(PersonneFrom form, Long id);
}