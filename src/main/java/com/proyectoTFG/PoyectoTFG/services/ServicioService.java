package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Servicio;

public interface ServicioService {
    List<Servicio> findAll();
    Servicio findById(Integer id);
    Servicio save(Servicio servicio);
    void deleteById(Integer id);
}
