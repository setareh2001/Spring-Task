package org.example.repository;

import org.example.model.Metadata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MetadataRepository extends JpaRepository<Metadata, Long> {

    @Query("SELECT m from Metadata m where m.program.id = :programId")
    Optional<Metadata> findMetadataByProgramId(@Param("programId") Long programId);
}
