package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Producto;

public interface ProductoService {
    
    List<Producto> findAll();
    Producto findById(Long id);
    Producto save(Producto producto);
    void deleteById(Long id);
}
