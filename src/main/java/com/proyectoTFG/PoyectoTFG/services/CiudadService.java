package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Ciudad;

public interface CiudadService {
    
    List<Ciudad> findAll();
    Ciudad findById(Long id);
    Ciudad save(Ciudad ciudad);
    void deleteById(Long id);
}
