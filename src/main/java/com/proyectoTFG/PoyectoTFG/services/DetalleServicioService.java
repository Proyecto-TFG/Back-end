package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.DetalleServicio;

public interface DetalleServicioService {
    
    List<DetalleServicio> findAll();
    DetalleServicio findById(Integer id);
    DetalleServicio save(DetalleServicio detalleServicio);
    void deleteById(Integer id);
}
