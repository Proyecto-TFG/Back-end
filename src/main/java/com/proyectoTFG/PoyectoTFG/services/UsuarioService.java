package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario trabajador);
    void deleteById(Long id);
    Usuario findByUserName(String username);
    boolean hasRole(Long id, String roleName);
    
}
