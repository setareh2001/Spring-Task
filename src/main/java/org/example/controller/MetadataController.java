package org.example.controller;

import org.example.controller.dto.MetadataRequestDTO;
import org.example.controller.dto.MetadataResponseDTO;
import org.example.service.MetadataService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping
    public List<MetadataResponseDTO> getAll() {
        return metadataService.getAll().stream()
                .map(MetadataResponseDTO::mapToDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{metadataId}")
    public MetadataResponseDTO getById(@PathVariable Long metadataId) {
        return MetadataResponseDTO.mapToDto(metadataService.getById(metadataId));
    }

    @PutMapping("/productionYear/{metadataId}")
    public MetadataResponseDTO changeProductionYear(@PathVariable Long metadataId) {
        return MetadataResponseDTO.mapToDto(
                metadataService.changeProductionYear(metadataId));
    }

    @PostMapping()
    public MetadataResponseDTO createMetadata(@RequestParam(required = true) Long programId ,@RequestBody MetadataRequestDTO dto) {
        return MetadataResponseDTO.mapToDto(
                metadataService.createMetadata(programId,dto));
    }

    @DeleteMapping("/delete/{metadataId}")
    public MetadataResponseDTO deleteMetadata(@PathVariable Long metadataId) {
        return MetadataResponseDTO.mapToDto(
                metadataService.deleteMetadata(metadataId));
    }
}
