package com.proyectoTFG.PoyectoTFG.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyectoTFG.PoyectoTFG.entities.ServicioSolicitado;

public interface ServicioSolicitadoRepository extends JpaRepository<ServicioSolicitado, Long>{
    
    List<ServicioSolicitado> findAllByIdCliente(Long idCliente);
}
