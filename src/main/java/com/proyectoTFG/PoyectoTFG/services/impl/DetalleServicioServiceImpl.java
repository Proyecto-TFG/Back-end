package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.DetalleServicio;
import com.proyectoTFG.PoyectoTFG.repositories.DetalleServicioRepository;
import com.proyectoTFG.PoyectoTFG.services.DetalleServicioService;

@Service
public class DetalleServicioServiceImpl implements DetalleServicioService{
    @Autowired
    private DetalleServicioRepository detalleServicioRepository;

    @Override
    public List<DetalleServicio> findAll() {
        return detalleServicioRepository.findAll();
    }

    @Override
    public DetalleServicio findById(Integer id) {
        return detalleServicioRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleServicio save(DetalleServicio detalleServicio) {
        return detalleServicioRepository.save(detalleServicio);
    }

    @Override
    public void deleteById(Integer id) {
        detalleServicioRepository.deleteById(id);
    }
}
