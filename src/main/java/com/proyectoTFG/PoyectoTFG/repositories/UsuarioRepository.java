package com.proyectoTFG.PoyectoTFG.repositories;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

  

    public Optional<Usuario> findByUserName(String email);
    
}
