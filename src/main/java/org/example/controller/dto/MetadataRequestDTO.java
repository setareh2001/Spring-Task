package org.example.controller.dto;


import lombok.*;
import org.example.model.Metadata;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class MetadataRequestDTO {

    private String productionYear;
    private String ageRating;
    private String movieLength;
    private Double imdbRating;

    public static Metadata mapToEntity(MetadataRequestDTO dto) {
        Metadata m = new Metadata();
        m.setProductionYear(dto.getProductionYear());
        m.setAgeRating(dto.getAgeRating());
        m.setMovieLength(dto.getMovieLength());
        m.setImdbRating(dto.getImdbRating());
        return m;
    }
}
