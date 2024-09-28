package org.example.repository;

import org.example.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    @Query("SELECT COUNT(p.id) >= 1 FROM Program p WHERE p.imdbCode = :imdbCode")
    Boolean existsByImdbCode(@Param("imdbCode") String imdbCode);

}

