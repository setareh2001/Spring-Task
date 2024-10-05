package org.example.service;

import org.example.cotroller.dto.MetadataRequestDTO;
import org.example.model.Metadata;
import org.example.model.Program;
import org.example.repository.MetadataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.time.Instant;
import java.util.List;

@Service
public class MetadataService {

    private final MetadataRepository metadataRepository;
    private final ProgramService programService;

    public MetadataService(ProgramService programService,MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
        this.programService = programService;
    }

    public List<Metadata> getAll() {
        return metadataRepository.findAll();
    }

    public Metadata getById(Long metadataId) {
        return metadataRepository.findById(metadataId).orElseThrow(() -> {
            throw new RuntimeException("Metadata not found with ID: " + metadataId);
        });
    }

    public Metadata createMetadata(Long programId,MetadataRequestDTO dto) {
        Program program = programService.getProgramById(programId);
        Metadata data = MetadataRequestDTO.mapToEntity(dto);

        data.setProgram(program);
        data.setCreatedAt(Instant.now());

        return metadataRepository.save(data);
    }

    public Metadata changeProductionYear(Long programId) {
        Metadata data = getById(programId);
        data.setProductionYear("1992");

        return metadataRepository.save(data);
    }

    public Metadata deleteMetadata(Long metadataId) {
        Metadata data = getById(metadataId);
        data.setDeleted(true);

        return metadataRepository.save(data);
    }
}
