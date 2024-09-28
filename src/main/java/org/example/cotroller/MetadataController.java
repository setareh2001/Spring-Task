package org.example.cotroller;

import org.example.model.Metadata;
import org.example.service.MetadataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/metadata")
public class MetadataController {

    private final MetadataService metadataService;

    public MetadataController(MetadataService metadataService) {
        this.metadataService = metadataService;
    }

    @GetMapping
    public List<Metadata> getAll() {
        return metadataService.getAll();
    }

    @GetMapping("/{metadataId}")
    public Metadata getById(@PathVariable Long metadataId) {
        return metadataService.getById(metadataId);
    }

}
