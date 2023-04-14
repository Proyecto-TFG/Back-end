package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Proovedor;

public interface ProovedorService {
    
    List<Proovedor> findAll();
    Proovedor findById(Integer id);
    Proovedor save(Proovedor proovedor);
    void deleteById(Integer id);
}
