package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.ServicioSolicitado;
import com.proyectoTFG.PoyectoTFG.repositories.ServicioSolicitadoRepository;
import com.proyectoTFG.PoyectoTFG.services.ServicioSolicitadoService;

@Service
public class ServicioSolicitadoServiceImpl implements ServicioSolicitadoService{

    @Autowired
    private ServicioSolicitadoRepository servicioSolicitadoRepository;

    @Override
    public List<ServicioSolicitado> findAll() {
        return servicioSolicitadoRepository.findAll();
    }

    @Override
    public ServicioSolicitado findById(Long id) {
        return servicioSolicitadoRepository.findById(id).orElse(null);
    }

    @Override
    public ServicioSolicitado save(ServicioSolicitado servicioSolicitado) {
        return servicioSolicitadoRepository.save(servicioSolicitado);
    }

    @Override
    public void deleteById(Long id) {
        servicioSolicitadoRepository.deleteById(id);
    }

    @Override
    public List<ServicioSolicitado> findAllByIdCliente(Long idCliente) {
        return servicioSolicitadoRepository.findAllByIdCliente(idCliente);
    }
    
    
}
