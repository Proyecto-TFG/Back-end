package com.proyectoTFG.PoyectoTFG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyectoTFG.PoyectoTFG.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
    
}
