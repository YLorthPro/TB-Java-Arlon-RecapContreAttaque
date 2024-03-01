package be.bstorm.formation.recapcontreattaque.api.models.dto;

import be.bstorm.formation.recapcontreattaque.dal.entities.MakerHub;

import java.time.LocalDate;

public record MakerHubDto(Long id,
                          String sujet,
                          boolean isProjecteurOk,
                          LocalDate dateDePresentation){
    
    public static MakerHubDto fromEntity(MakerHub entity){
        return new MakerHubDto(entity.getId(), entity.getSujet(), entity.isProjecteurOk(), entity.getDateDePresentation());
    }
}