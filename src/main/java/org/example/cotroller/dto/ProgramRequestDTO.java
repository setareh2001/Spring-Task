package org.example.cotroller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.model.Program;
import org.example.model.ProgramType;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequestDTO {

    private String farsiTitle;
    private String englishTitle;
    private String description;

    @NotNull
    @NotBlank
    @Size(min = 9)
    private String imdbCode;

    private ProgramType type;

    public static Program mapToEntity(ProgramRequestDTO req) {
        Program p = new Program();
        p.setFarsiTitle(req.getFarsiTitle());
        p.setEnglishTitle(req.getEnglishTitle());
        p.setDescription(req.getDescription());
        p.setImdbCode(req.getImdbCode());
        p.setType(req.getType());

        return p;
    }

}
