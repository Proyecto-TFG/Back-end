package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;


import com.proyectoTFG.PoyectoTFG.entities.Rol;


public interface RolService {
    
    List<Rol> findAll();
    Rol findById(Long id);
    Rol findByNombre(String nombre);
    Rol save(Rol rol);
    void deleteById(Long id);
}