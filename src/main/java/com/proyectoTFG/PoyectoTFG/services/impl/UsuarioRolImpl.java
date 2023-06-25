package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRolRepository;
import com.proyectoTFG.PoyectoTFG.services.UsuarioRolService;

@Service
public class UsuarioRolImpl implements UsuarioRolService{
    
    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Override
    public List<UsuarioRol> findAll() {
        return usuarioRolRepository.findAll();
    }

    @Override
    public UsuarioRol findById(Long id) {
        return usuarioRolRepository.findById(id).orElse(null);
    }

    @Override
    public UsuarioRol save(UsuarioRol usuarioRol) {
        return usuarioRolRepository.save(usuarioRol);
    }

    @Override
    public void deleteById(Long id) {
        usuarioRolRepository.deleteById(id);
    }

    @Override
    public List<UsuarioRol> findByUsuarioId(Long idUsuario) {
        return usuarioRolRepository.findByIdUsuario(idUsuario);
    }

    @Override
    @Transactional
    public void deleteUsuarioRolesByIdUsuario(Long idUsuario) {
        usuarioRolRepository.deleteAllByIdUsuario(idUsuario);
    }

    @Override
    @Transactional
    public void deleteAllByIdUsuario(Long idUsuario) {
        List<UsuarioRol> usuarioRoles = usuarioRolRepository.findByIdUsuario(idUsuario);
        usuarioRolRepository.deleteAll(usuarioRoles);
    }

    

}
