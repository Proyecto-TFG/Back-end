package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;

public interface UsuarioRolService {
    List<UsuarioRol> findAll();
    UsuarioRol findById(Long id);
    List<UsuarioRol> findByUsuarioId(Long usuarioId);
    UsuarioRol save(UsuarioRol usuarioRol);
    void deleteById(Long id);
    void deleteUsuarioRolesByIdUsuario(Long idUsuario);
    void deleteAllByIdUsuario(Long idUsuario);
}
