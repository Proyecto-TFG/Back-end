package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Pais;
import com.proyectoTFG.PoyectoTFG.repositories.PaisRepository;
import com.proyectoTFG.PoyectoTFG.services.PaisService;

@Service
public class PaisServiceImpl implements PaisService{
    @Autowired
    private PaisRepository paisRepository;

    @Override
    public List<Pais> findAll() {
        return paisRepository.findAll();
    }

    @Override
    public Pais findById(Long id) {
        return paisRepository.findById(id).orElse(null);
    }

    @Override
    public Pais save(Pais pais) {
        return paisRepository.save(pais);
    }

    @Override
    public void deleteById(Long id) {
        paisRepository.deleteById(id);
    }
}
