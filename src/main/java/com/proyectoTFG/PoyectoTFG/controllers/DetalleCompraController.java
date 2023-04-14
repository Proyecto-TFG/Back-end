package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.entities.DetalleCompra;
import com.proyectoTFG.PoyectoTFG.services.DetalleCompraService;

@RestController
@RequestMapping("/api/detalles-compra")
public class DetalleCompraController {
    
    @Autowired
    private DetalleCompraService detalleCompraService;

    @GetMapping
    public ResponseEntity<List<DetalleCompra>> findAll() {
        List<DetalleCompra> detallesCompra = detalleCompraService.findAll();
        return ResponseEntity.ok(detallesCompra);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleCompra> findById(@PathVariable Integer id) {
        DetalleCompra detalleCompra = detalleCompraService.findById(id);
        if (detalleCompra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalleCompra);
    }

    @PostMapping
    public ResponseEntity<DetalleCompra> save(@RequestBody DetalleCompra detalleCompra) {
        DetalleCompra savedDetalleCompra = detalleCompraService.save(detalleCompra);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetalleCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleCompra> update(@PathVariable Integer id, @RequestBody DetalleCompra detalleCompra) {
        DetalleCompra existingDetalleCompra = detalleCompraService.findById(id);
        if (existingDetalleCompra == null) {
            return ResponseEntity.notFound().build();
        }
        detalleCompra.setIdDetalle(id);
        DetalleCompra updatedDetalleCompra = detalleCompraService.save(detalleCompra);
        return ResponseEntity.ok(updatedDetalleCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        DetalleCompra detalleCompra = detalleCompraService.findById(id);
        if (detalleCompra == null) {
            return ResponseEntity.notFound().build();
        }
        detalleCompraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
