package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.DetalleCompra;
import com.proyectoTFG.PoyectoTFG.repositories.DetalleCompraRepository;
import com.proyectoTFG.PoyectoTFG.services.DetalleCompraService;

@Service
public class DetalleCompraServiceImpl implements DetalleCompraService{
    @Autowired
    private DetalleCompraRepository detalleCompraRepository;

    @Override
    public List<DetalleCompra> findAll() {
        return detalleCompraRepository.findAll();
    }

    @Override
    public DetalleCompra findById(Integer id) {
        return detalleCompraRepository.findById(id).orElse(null);
    }

    @Override
    public DetalleCompra save(DetalleCompra detalleCompra) {
        return detalleCompraRepository.save(detalleCompra);
    }

    @Override
    public void deleteById(Integer id) {
        detalleCompraRepository.deleteById(id);
    }
}
