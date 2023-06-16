package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Compra;
import com.proyectoTFG.PoyectoTFG.repositories.CompraRepository;
import com.proyectoTFG.PoyectoTFG.services.CompraService;

@Service
public class CompraServiceImpl implements CompraService{
    @Autowired
    private CompraRepository compraRepository;

    @Override
    public List<Compra> findAll() {
        return compraRepository.findAll();
    }

    @Override
    public Compra findById(Long id) {
        return compraRepository.findById(id).orElse(null);
    }

    @Override
    public Compra save(Compra compra) {
        return compraRepository.save(compra);
    }

    @Override
    public void deleteById(Long id) {
        compraRepository.deleteById(id);
    }
}
