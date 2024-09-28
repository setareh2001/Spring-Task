package org.example.cotroller.dto;


import lombok.*;
import org.example.model.Program;
import org.example.model.ProgramType;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramResponseDTO {


    private Long id;

    private String farsiTitle;
    private String englishTitle;
    private String image;
    private String description;
    private Boolean enabled;
    private String imdbCode;
    private ProgramType type;

    public static ProgramResponseDTO mapToDto(Program program) {
        return new ProgramResponseDTO(
                program.getId(),
                program.getFarsiTitle(),
                program.getEnglishTitle(),
                program.getImage(),
                program.getDescription(),
                program.getEnabled(),
                program.getImdbCode(),
                program.getType()
        );
    }

    @Override
    public String toString() {
        return "ProgramResponseDTO{" +
                "id=" + id +
                ", farsiTitle='" + farsiTitle + '\'' +
                ", englishTitle='" + englishTitle + '\'' +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", enabled=" + enabled +
                ", imdbCode='" + imdbCode + '\'' +
                ", type=" + type +
                '}';
    }
}
