package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.ServicioDisponible;
import com.proyectoTFG.PoyectoTFG.repositories.ServicioDisponibleRepository;
import com.proyectoTFG.PoyectoTFG.services.ServicioDisponibleService;

@Service
public class ServicioDisponibleServiceImpl implements ServicioDisponibleService{

    @Autowired
    private ServicioDisponibleRepository servicioDisponibleRepository;


    @Override
    public List<ServicioDisponible> findAll() {
        return servicioDisponibleRepository.findAll();
    }


    @Override
    public ServicioDisponible findById(Long id) {
        return servicioDisponibleRepository.findById(id).orElse(null);
    }


    @Override
    public ServicioDisponible save(ServicioDisponible servicioDisponible) {
        return servicioDisponibleRepository.save(servicioDisponible);
    }


    @Override
    public void deleteById(Long id) {
        servicioDisponibleRepository.deleteById(id);
    }

    
    
}
