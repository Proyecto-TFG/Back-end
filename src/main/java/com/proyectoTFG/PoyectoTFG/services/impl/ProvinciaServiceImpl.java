package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Provincia;
import com.proyectoTFG.PoyectoTFG.repositories.ProvinciaRepository;
import com.proyectoTFG.PoyectoTFG.services.ProvinciaService;

@Service
public class ProvinciaServiceImpl implements ProvinciaService{
    
    @Autowired
    private ProvinciaRepository provinciaRepository;

    @Override
    public List<Provincia> findAll() {
        return provinciaRepository.findAll();
    }

    @Override
    public Provincia findById(Long id) {
        return provinciaRepository.findById(id).orElse(null);
    }

    @Override
    public Provincia save(Provincia provincia) {
        return provinciaRepository.save(provincia);
    }

    @Override
    public void deleteById(Long id) {
        provinciaRepository.deleteById(id);
    }
}
