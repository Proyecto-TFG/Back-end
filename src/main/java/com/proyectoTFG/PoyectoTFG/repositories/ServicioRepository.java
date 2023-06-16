package com.proyectoTFG.PoyectoTFG.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyectoTFG.PoyectoTFG.entities.Servicio;


public interface ServicioRepository extends JpaRepository<Servicio, Integer>{

    List<Servicio> findAllByIdCliente(Long idCliente);
    
}
