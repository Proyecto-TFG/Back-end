package com.proyectoTFG.PoyectoTFG.services;

import java.util.List;

import com.proyectoTFG.PoyectoTFG.entities.DetalleCompra;

public interface DetalleCompraService {
    List<DetalleCompra> findAll();
    DetalleCompra findById(Integer id);
    DetalleCompra save(DetalleCompra detalleCompra);
    void deleteById(Integer id);
}
