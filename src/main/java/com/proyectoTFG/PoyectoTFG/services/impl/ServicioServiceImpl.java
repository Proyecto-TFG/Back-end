package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Servicio;
import com.proyectoTFG.PoyectoTFG.repositories.ServicioRepository;
import com.proyectoTFG.PoyectoTFG.services.ServicioService;

@Service
public class ServicioServiceImpl implements ServicioService{
    
    @Autowired
    private ServicioRepository servicioRepository;

    @Override
    public List<Servicio> findAll() {
        return servicioRepository.findAll();
    }

    @Override
    public Servicio findById(Integer id) {
        return servicioRepository.findById(id).orElse(null);
    }

    @Override
    public Servicio save(Servicio servicio) {
        return servicioRepository.save(servicio);
    }

    @Override
    public void deleteById(Integer id) {
        servicioRepository.deleteById(id);
    }
}
