package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Proovedor;

public interface ProovedorService {
    
    List<Proovedor> findAll();
    Proovedor findById(Long id);
    Proovedor save(Proovedor proovedor);
    void deleteById(Long id);
}
