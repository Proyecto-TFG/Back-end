package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.ServicioDisponible;

public interface ServicioDisponibleService {
    
    List<ServicioDisponible> findAll();
    ServicioDisponible findById(Long id);
    ServicioDisponible save(ServicioDisponible servicioDisponible);
    void deleteById(Long id);
}
