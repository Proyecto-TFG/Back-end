package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Rol;
import com.proyectoTFG.PoyectoTFG.repositories.RolRepository;
import com.proyectoTFG.PoyectoTFG.services.RolService;

@Service
public class RolServiceImpl implements RolService{
    
    @Autowired
    private RolRepository rolRepository;

    @Override
    //@Transactional
    public List<Rol> findAll() {
        return rolRepository.findAll();
    }

    @Override
    public Rol findById(Long id) {
        return rolRepository.findById(id).orElse(null);
    }

    @Override
    public Rol save(Rol rol) {
        return rolRepository.save(rol);
    }

    @Override
    public void deleteById(Long id) {

        rolRepository.deleteById(id);
    }



    @Override
    public Rol findByNombre(String nombre) {
        return rolRepository.findByNombre(nombre);
    }


}
