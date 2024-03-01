package be.bstorm.formation.recapcontreattaque.api.controller;

import be.bstorm.formation.recapcontreattaque.api.models.dto.MakerHubDto;
import be.bstorm.formation.recapcontreattaque.api.models.forms.MakerHubForm;
import be.bstorm.formation.recapcontreattaque.bll.MakerHubService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/makerhub")
public class MakerHubController {
    
    private final MakerHubService makerHubService;

    public MakerHubController(MakerHubService makerHubService) {
        this.makerHubService = makerHubService;
    }
    
    // Coucou
    
    @PostMapping("/create")
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody MakerHubForm form){
        makerHubService.create(form);
    }
    
    @GetMapping("/{id:[0-9]+}")
    public ResponseEntity<MakerHubDto> getOne(@PathVariable Long id){
        return ResponseEntity.ok(MakerHubDto.fromEntity(makerHubService.getOne(id).orElseThrow(()-> new EntityNotFoundException("Pas trouvé"))));
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<MakerHubDto>> getAll(){
        return ResponseEntity.ok(makerHubService.getAll().stream().map(MakerHubDto::fromEntity).toList());
    }
    
    @PutMapping("/{id:[0-9]+}")
    public void update(@PathVariable("id") Long makerhubId, @RequestBody MakerHubForm form){
        makerHubService.update(form, makerhubId);
    }
    
    @DeleteMapping("/{id:[0-9]+}")
    public void delete(@PathVariable Long id){
        makerHubService.delete(id);
    }
}
