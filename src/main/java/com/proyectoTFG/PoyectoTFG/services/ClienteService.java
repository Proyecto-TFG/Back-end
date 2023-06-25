package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.Cliente;

public interface ClienteService {
    
    List<Cliente> findAll();
    Cliente findById(Long id);
    Cliente findByIdUsuario(Long id);
    Cliente save(Cliente cliente);
    void deleteById(Long id);
    void deleteByIdUsuario(Long id);
}
