package com.proyectoTFG.PoyectoTFG.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

  

    public Usuario findByUserName(String email);
    public boolean existsByUserName(String userName);
    
    
}
