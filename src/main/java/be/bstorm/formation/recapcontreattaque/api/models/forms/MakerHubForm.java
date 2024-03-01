package be.bstorm.formation.recapcontreattaque.api.models.forms;

import java.time.LocalDate;

public record MakerHubForm(
        String sujet,
        boolean isProjecteurOk,
        LocalDate dateDePresentation
) {
}
