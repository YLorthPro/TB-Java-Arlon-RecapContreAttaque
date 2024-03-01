package be.bstorm.formation.recapcontreattaque.bll;

import be.bstorm.formation.recapcontreattaque.api.models.forms.MakerHubForm;
import be.bstorm.formation.recapcontreattaque.dal.entities.MakerHub;
import be.bstorm.formation.recapcontreattaque.dal.repositories.MakerHubRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MakerHubServiceImpl implements MakerHubService{


    private final MakerHubRepository makerHubRepository;

    public MakerHubServiceImpl(MakerHubRepository makerHubRepository) {
        this.makerHubRepository = makerHubRepository;
    }

    @Override
    public Optional<MakerHub> getOne(Long id) {
        return makerHubRepository.findById(id);
    }

    @Override
    public void create(MakerHubForm form) {
        
        if(form == null)
            throw new IllegalArgumentException("form ne peut être null");
        
        MakerHub leNomDeMaVariable = new MakerHub();
        leNomDeMaVariable.setSujet(form.sujet());
        leNomDeMaVariable.setProjecteurOk(form.isProjecteurOk());
        leNomDeMaVariable.setDateDePresentation(form.dateDePresentation());
        makerHubRepository.save(leNomDeMaVariable);
    }

    @Override
    public void update(MakerHubForm form, Long id) {
        if(form == null)
            throw new IllegalArgumentException("form ne peut être null");
        
        MakerHub leNomDeMaVariable = getOne(id).orElseThrow(()-> new EntityNotFoundException("Pas trouvé"));
        leNomDeMaVariable.setSujet(form.sujet());
        leNomDeMaVariable.setProjecteurOk(form.isProjecteurOk());
        leNomDeMaVariable.setDateDePresentation(form.dateDePresentation());
        makerHubRepository.save(leNomDeMaVariable);
    }

    @Override
    public List<MakerHub> getAll() {
        return makerHubRepository.findAll();
    }

    @Override
    public void delete(Long id) {
        makerHubRepository.deleteById(id);
    }
}
