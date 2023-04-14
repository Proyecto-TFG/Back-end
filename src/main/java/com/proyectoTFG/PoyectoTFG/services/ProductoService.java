package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Producto;

public interface ProductoService {
    
    List<Producto> findAll();
    Producto findById(Integer id);
    Producto save(Producto producto);
    void deleteById(Integer id);
}
