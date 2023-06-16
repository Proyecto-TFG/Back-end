package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Provincia;

public interface ProvinciaService {
    
    List<Provincia> findAll();
    Provincia findById(Long id);
    Provincia save(Provincia provincia);
    void deleteById(Long id);
}
