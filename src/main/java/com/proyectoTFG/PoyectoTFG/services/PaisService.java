package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Pais;

public interface PaisService {
    
    List<Pais> findAll();
    Pais findById(Integer id);
    Pais save(Pais pais);
    void deleteById(Integer id);
}
