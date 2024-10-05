package org.example.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
    private String farsiTitle;
    private String englishTitle;
    private String imdbCode;

    private String productionYear;
    private String ageRating;
    private String movieLength;
    private Double imdbRating;
}
