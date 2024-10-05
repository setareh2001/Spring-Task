package org.example.cotroller.dto;


import lombok.*;
import org.example.model.Metadata;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MetadataResponseDTO {

    private Long id;

    private String productionYear;
    private String ageRating;
    private String movieLength;
    private Double imdbRating;

    public static MetadataResponseDTO mapToDto(Metadata metadata) {
        return new MetadataResponseDTO(metadata.getId(),
                metadata.getProductionYear(),
                metadata.getAgeRating(),
                metadata.getMovieLength(),
                metadata.getImdbRating());
    }

}
