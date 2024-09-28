package org.example.service;

import org.example.cotroller.dto.ProgramRequestDTO;
import org.example.model.Program;
import org.example.repository.ProgramRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ProgramService {

    private final ProgramRepository programRepository;

    //Dependency Injection
    public ProgramService(ProgramRepository programRepository) {
        this.programRepository = programRepository;
    }

    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    public Program getProgramById(Long programId) {
        return programRepository.findById(programId).orElseThrow(() -> {
            throw new RuntimeException("Program Not Found with ID: " + programId);
        });
    }

    public Program createProgram(ProgramRequestDTO dto) {
        if (programRepository.existsByImdbCode(dto.getImdbCode())) throw new RuntimeException("Duplicate Imdb Code");

        Program mappedProgram = ProgramRequestDTO.mapToEntity(dto);
        mappedProgram.setEnabled(false);
        mappedProgram.setCreatedAt(Instant.now());

        return programRepository.save(mappedProgram);
    }

    public Program enableProgram(Long programId, boolean flag) {
        Program program = getProgramById(programId);
        program.setEnabled(flag);

        return programRepository.save(program);
    }
}
