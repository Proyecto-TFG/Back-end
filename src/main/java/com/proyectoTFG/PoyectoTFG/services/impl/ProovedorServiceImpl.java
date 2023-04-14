package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Proovedor;
import com.proyectoTFG.PoyectoTFG.repositories.ProovedorRepository;
import com.proyectoTFG.PoyectoTFG.services.ProovedorService;

@Service
public class ProovedorServiceImpl implements ProovedorService{
    @Autowired
    private ProovedorRepository proovedorRepository;

    @Override
    public List<Proovedor> findAll() {
        return proovedorRepository.findAll();
    }

    @Override
    public Proovedor findById(Integer id) {
        return proovedorRepository.findById(id).orElse(null);
    }

    @Override
    public Proovedor save(Proovedor proovedor) {
        return proovedorRepository.save(proovedor);
    }

    @Override
    public void deleteById(Integer id) {
        proovedorRepository.deleteById(id);
    }
}
