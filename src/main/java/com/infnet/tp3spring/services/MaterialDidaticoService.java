package com.infnet.tp3spring.services;


import com.infnet.tp3spring.models.MaterialDidatico;
import com.infnet.tp3spring.repositories.MaterialDidaticoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialDidaticoService {

    @Autowired
    private MaterialDidaticoRepository materialDidaticoRepository;

    public MaterialDidatico saveMaterialDidatico(MaterialDidatico materialDidatico) {
        return materialDidaticoRepository.save(materialDidatico);
    }

    public List<MaterialDidatico> getAllMaterialDidatico() {
        return materialDidaticoRepository.findAll();
    }

    public Optional<MaterialDidatico> getMaterialDidaticoById(String id) {
        return materialDidaticoRepository.findById(id);
    }

    public void deleteMaterialDidatico(String id) {
        materialDidaticoRepository.deleteById(id);
    }
}