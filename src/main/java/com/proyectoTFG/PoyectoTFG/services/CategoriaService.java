package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Categoria;

public interface CategoriaService {
    
    List<Categoria> findAll();
    Categoria findById(Integer id);
    Categoria save(Categoria categoria);
    void deleteById(Integer id);
}
