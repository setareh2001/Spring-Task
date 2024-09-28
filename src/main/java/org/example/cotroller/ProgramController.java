package org.example.cotroller;


import org.example.cotroller.dto.ProgramRequestDTO;
import org.example.cotroller.dto.ProgramResponseDTO;
import org.example.model.Program;
import org.example.service.ProgramService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;
import java.util.logging.Logger;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/program")
public class ProgramController {
    private final ProgramService service;

    ProgramController(ProgramService service) {
        this.service = service;
    }

    private static Logger logger = Logger.getLogger(ProgramController.class.getName());

    @GetMapping
    public List<ProgramResponseDTO> all() {
        return service.getAllPrograms().stream()
                .map(ProgramResponseDTO::mapToDto)
                .collect(Collectors.toList());

    }

    @GetMapping("/{programId}")
    public ProgramResponseDTO getByProgramId(@PathVariable Long programId) {
        return ProgramResponseDTO.mapToDto(service.getProgramById(programId));
    }

    @PostMapping("/create")
    public ProgramResponseDTO createProgram(@Validated @RequestBody ProgramRequestDTO dto) {
        Program program = service.createProgram(dto);

        return ProgramResponseDTO.mapToDto(program);
    }

    @PutMapping("/enable/{programId}")
    public ProgramResponseDTO enableProgram(@PathVariable Long programId) {
        return ProgramResponseDTO.mapToDto(
                service.enableProgram(programId,true)
        );
    }

    @PutMapping("/disable/{programId}")
    public ProgramResponseDTO disableProgram(@PathVariable Long programId) {
        return ProgramResponseDTO.mapToDto(
                service.enableProgram(programId,false)
        );
    }

    @PostMapping("/imdb")
    public ResponseEntity<Program> createProgram(@RequestHeader String requestID, @RequestBody Program program) {
        logger.info("Received request with id " + requestID + "; program Code: " + program.getImdbCode());

        program.setId(new Random().nextLong());

        return ResponseEntity.status(HttpStatus.OK).header("requestID", requestID).body(program);
    }
}