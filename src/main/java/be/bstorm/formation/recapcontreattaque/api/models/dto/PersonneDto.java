package be.bstorm.formation.recapcontreattaque.api.models.dto;

import be.bstorm.formation.recapcontreattaque.dal.entities.Personne;

import java.util.List;

public record PersonneDto(
        Long id,
        String nom,
        List<MakerHubDto> makerHubs
) {
    public static PersonneDto fromEntity(Personne entity){
        return new PersonneDto(entity.getId(), entity.getNom(), entity.getMakerHubs().stream().map(MakerHubDto::fromEntity).toList());
    }
}
