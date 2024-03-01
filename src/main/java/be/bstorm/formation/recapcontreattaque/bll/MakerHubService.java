package be.bstorm.formation.recapcontreattaque.bll;

import be.bstorm.formation.recapcontreattaque.api.models.forms.MakerHubForm;
import be.bstorm.formation.recapcontreattaque.dal.entities.MakerHub;

import java.util.List;
import java.util.Optional;

public interface MakerHubService {
    
    Optional<MakerHub> getOne(Long id);
    void create(MakerHubForm form);
    void update(MakerHubForm form, Long id);
    List<MakerHub> getAll();
    void delete(Long id);
    
}
