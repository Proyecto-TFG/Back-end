package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Trabajador;
import com.proyectoTFG.PoyectoTFG.repositories.TrabajadorRepository;
import com.proyectoTFG.PoyectoTFG.services.TrabajadorService;

@Service
public class TrabajadorServiceImpl implements TrabajadorService {

    @Autowired
    private TrabajadorRepository trabajadorRepository;

    @Override
    public List<Trabajador> findAll() {
        return trabajadorRepository.findAll();
    }

    @Override
    public Trabajador findById(Long id) {
        return trabajadorRepository.findById(id).orElse(null);
    }

    @Override
    public Trabajador save(Trabajador trabajador) {
        return trabajadorRepository.save(trabajador);
    }

    @Override
    public void deleteById(Long id) {
        trabajadorRepository.deleteById(id);
    }

    @Override
    public Trabajador obtenerTrabajadorPorIdUsuario(Long idUsuario) {
        return trabajadorRepository.findByIdUsuario(idUsuario);
    }


}
