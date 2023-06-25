package com.proyectoTFG.PoyectoTFG.repositories;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyectoTFG.PoyectoTFG.entities.Cliente;


public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    Cliente findByIdUsuario(Long id);
    void deleteByIdUsuario(Long id);
    
}
