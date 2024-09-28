package org.example.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "t_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Metadata {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String productionYear;
    private String ageRating;
    private String movieLength;
    private Double imdbRating;

    @OneToOne
    @JoinColumn(name = "fk_program")
    private Program program;

    private Instant createdAt;
    private Instant updateAt;


}
