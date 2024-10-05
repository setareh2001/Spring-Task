package org.example.repository;

import org.example.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;


@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {

    @Query("SELECT COUNT(p.id) >= 1 FROM Program p WHERE p.imdbCode = :imdbCode")
    Boolean existsByImdbCode(@Param("imdbCode") String imdbCode);

    @Query("SELECT p from Program as p where p.enabled = true")
    List<Program> findProgramsByEnabled();

    @Query("SELECT p from Program as p where p.imdbCode = :imdbCode")
    Optional<Program> findProgramByImdbCode(@Param("imdbCode") String imdbCode);


}

