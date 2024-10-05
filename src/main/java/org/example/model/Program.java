package org.example.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_program")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Program {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String farsiTitle;
    private String englishTitle;
    private String image;
    private String description;
    private Boolean enabled;
    private String imdbCode;
    private boolean isDeleted;

    @Enumerated(value = EnumType.STRING)
    private ProgramType type;

    private Instant createdAt;
    private Instant UpdatedAt;

}