package org.example.service;

import org.example.model.Metadata;
import org.example.repository.MetadataRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Service
public class MetadataService {

    private final MetadataRepository metadataRepository;

    public MetadataService(MetadataRepository metadataRepository) {
        this.metadataRepository = metadataRepository;
    }

    public List<Metadata> getAll() {
        return metadataRepository.findAll();
    }

    public Metadata getById(Long metadataId) {
        return metadataRepository.findById(metadataId).orElseThrow(() -> {
            throw new RuntimeException("Metadata not found with ID: " + metadataId);
        });
    }

//    public Metadata getByEnable(Long metadataId) {
//        metadataRepository.findById()
//    }
}
