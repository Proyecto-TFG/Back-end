package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;

public interface UsuarioService {

    List<Usuario> findAll();
    Usuario findById(Integer id);
    Usuario save(Usuario trabajador);
    void deleteById(Integer id);
    Usuario findByUserName(String email);
    
}
