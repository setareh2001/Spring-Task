package org.example.cotroller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.example.cotroller.dto.MetadataRequestDTO;
import org.example.cotroller.dto.MetadataResponseDTO;
import org.example.cotroller.dto.ProgramRequestDTO;
import org.example.model.Metadata;
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

    @PostMapping("/create")
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
