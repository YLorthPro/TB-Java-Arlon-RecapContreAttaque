package be.bstorm.formation.recapcontreattaque.bll;

import be.bstorm.formation.recapcontreattaque.api.models.forms.PersonneFrom;
import be.bstorm.formation.recapcontreattaque.dal.entities.Personne;
import be.bstorm.formation.recapcontreattaque.dal.repositories.PersonneRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonneServiceImpl implements PersonneService{
    
    private final PersonneRepository personneRepository;
    
    public PersonneServiceImpl(PersonneRepository personneRepository) {
        this.personneRepository = personneRepository;
    }

    @Override
    public Optional<Personne> getOne(Long id) {
        return personneRepository.findById(id);
    }

    @Override
    public List<Personne> getAll() {
        return personneRepository.findAll();
    }

    @Override
    public void create(PersonneFrom form) {
        if(form == null)
            throw new IllegalArgumentException("form ne peut pas être null ;) (besoin de café, mais pas dans le PC) => Aline");
        
        Personne personne = new Personne();
        personne.setNom(form.nom());
        personneRepository.save(personne);
    }

    @Override
    public void update(PersonneFrom form, Long id) {
        if(form == null)
            throw new IllegalArgumentException("form ne peut pas être null ;) (besoin de café, mais pas dans le PC) => Aline");

        Personne personne = personneRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Pas trouvé"));
        personne.setNom(form.nom());
        personneRepository.save(personne);
    }

}
