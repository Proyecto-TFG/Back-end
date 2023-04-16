package com.proyectoTFG.PoyectoTFG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.PoyectoTFG.entities.Rol;

public interface RolRepository extends JpaRepository<Rol, Long>{
    Rol findByNombre(String nombre);
    
}
