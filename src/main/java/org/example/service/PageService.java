package org.example.service;


import org.example.model.Metadata;
import org.example.model.Movie;
import org.example.model.Program;
import org.example.repository.MetadataRepository;
import org.example.repository.ProgramRepository;
import org.springframework.stereotype.Service;

@Service
public class PageService {

    private final ProgramRepository programRepository;
    private final MetadataRepository metadataRepository;


    PageService(ProgramRepository programRepository,MetadataRepository metadataRepository) {
        this.programRepository = programRepository;
        this.metadataRepository = metadataRepository;
    }

    public Movie getMovieByImdbCode(String imdbCode) {
        Program program = programRepository.findProgramByImdbCode(imdbCode).orElseThrow(() -> {
            throw new RuntimeException("The program does not exist" + imdbCode);
        });

        Metadata metadata = metadataRepository.findMetadataByProgramId(program.getId()).orElseThrow(() -> {
            throw new RuntimeException("The metadata does not exist " + program.getId());
        });


        Movie movie = new Movie();
        movie.setProductionYear(metadata.getProductionYear());
        movie.setMovieLength(metadata.getMovieLength());
        movie.setAgeRating(metadata.getAgeRating());
        movie.setImdbRating(metadata.getImdbRating());

        movie.setImdbCode(program.getImdbCode());
        movie.setEnglishTitle(program.getEnglishTitle());
        movie.setFarsiTitle(program.getFarsiTitle());

        return movie;
    }
}
