package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.ServicioSolicitado;

public interface ServicioSolicitadoService {
    
    List<ServicioSolicitado> findAll();
    ServicioSolicitado findById(Long id);
    ServicioSolicitado save(ServicioSolicitado servicioSolicitado);
    void deleteById(Long id);
    List<ServicioSolicitado> findAllByIdCliente (Long idCliente);
}
