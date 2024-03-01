package be.bstorm.formation.recapcontreattaque.api.controller;

import be.bstorm.formation.recapcontreattaque.api.models.dto.PersonneDto;
import be.bstorm.formation.recapcontreattaque.api.models.forms.PersonneFrom;
import be.bstorm.formation.recapcontreattaque.bll.PersonneService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/personne")
public class PersonneController {
    private final PersonneService personneService;

    public PersonneController(PersonneService personneService) {
        this.personneService = personneService;
    }
    
    @GetMapping("/{id: [0-9]+}")
    public ResponseEntity<PersonneDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(personneService.getOne(id).map(PersonneDto::fromEntity).orElseThrow(()-> new EntityNotFoundException("Toujours pas trouvé")));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<PersonneDto>> getAll(){
        return ResponseEntity.ok(personneService.getAll().stream().map(PersonneDto::fromEntity).toList());
    }
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody PersonneFrom form){
        personneService.create(form);
    }

    @PutMapping("/{id: [0-9]+}")
    public void create(@RequestBody PersonneFrom form, @PathVariable Long id){
        personneService.update(form, id);
    }
}
