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

import com.proyectoTFG.PoyectoTFG.entities.Compra;
import com.proyectoTFG.PoyectoTFG.services.CompraService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @GetMapping
    public ResponseEntity<List<Compra>> findAll() {
        List<Compra> compras = compraService.findAll();
        return ResponseEntity.ok(compras);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Integer id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compra);
    }

    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        Compra savedCompra = compraService.save(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompra);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Compra> update(@PathVariable Integer id, @RequestBody Compra compra) {
        Compra existingCompra = compraService.findById(id);
        if (existingCompra == null) {
            return ResponseEntity.notFound().build();
        }
        compra.setIdCompra(id);
        Compra updatedCompra = compraService.save(compra);
        return ResponseEntity.ok(updatedCompra);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        compraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
