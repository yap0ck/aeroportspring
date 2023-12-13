package be.gaetan.aeroportspring.pl.models.pilote.dto;

import be.gaetan.aeroportspring.dal.models.Pilote;

public record PiloteShortDto(
        long id,
        String name,
        String phoneNumber
) {
    /**
     * Converts a Pilote entity object into a PiloteShortDto object.
     *
     * @param pilote The Pilote entity object to be converted.
     * @return The PiloteShortDto object created from the Pilote entity object.
     */
    public static PiloteShortDto fromEntity(Pilote pilote){
        return new PiloteShortDto(pilote.getId(), pilote.getName(), pilote.getPhoneNumber());
    }
}
