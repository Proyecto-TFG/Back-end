package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Ciudad;
import com.proyectoTFG.PoyectoTFG.repositories.CiudadRepository;
import com.proyectoTFG.PoyectoTFG.services.CiudadService;

@Service
public class CiudadServiceImpl implements CiudadService{
    @Autowired
    private CiudadRepository ciudadRepository;

    @Override
    public List<Ciudad> findAll() {
        return ciudadRepository.findAll();
    }

    @Override
    public Ciudad findById(Long id) {
        return ciudadRepository.findById(id).orElse(null);
    }

    @Override
    public Ciudad save(Ciudad ciudad) {
        return ciudadRepository.save(ciudad);
    }

    @Override
    public void deleteById(Long id) {
        ciudadRepository.deleteById(id);
    }
}
