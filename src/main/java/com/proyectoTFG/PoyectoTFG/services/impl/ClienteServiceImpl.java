package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Cliente;
import com.proyectoTFG.PoyectoTFG.repositories.ClienteRepository;
import com.proyectoTFG.PoyectoTFG.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).orElse(null);
    }

    @Override
    public Cliente findByIdUsuario(Long id) {
        return clienteRepository.findByIdUsuario(id);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void deleteById(Long id) {
        clienteRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void deleteByIdUsuario(Long id) {
        
        clienteRepository.deleteByIdUsuario(id);
    }

    
    
}
