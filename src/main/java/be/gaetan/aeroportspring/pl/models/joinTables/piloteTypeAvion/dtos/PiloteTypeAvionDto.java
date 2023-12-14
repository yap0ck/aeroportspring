package be.gaetan.aeroportspring.pl.models.joinTables.piloteTypeAvion.dtos;

import be.gaetan.aeroportspring.dal.models.joinTables.PiloteTypeAvion;

public record PiloteTypeAvionDto(
        long id,
        int nbVols,
        long piloteId,
        long typeAvionId
) {
    public static PiloteTypeAvionDto fromEntity(PiloteTypeAvion entity){
        return new PiloteTypeAvionDto(
                entity.getId(),
                entity.getNbVols(),
                entity.getPilote().getId(),
                entity.getTypeAvion().getId()
        );
    }
}
