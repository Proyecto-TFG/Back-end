package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;
import java.util.Optional;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Long id);
    Usuario save(Usuario trabajador);
    void deleteById(Long id);
    Optional <Usuario> findByUserName(String email);
    
}
