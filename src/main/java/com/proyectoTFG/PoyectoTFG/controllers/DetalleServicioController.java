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

import com.proyectoTFG.PoyectoTFG.entities.DetalleServicio;
import com.proyectoTFG.PoyectoTFG.services.DetalleServicioService;

@RestController
@RequestMapping("/api/detalleservicios")
public class DetalleServicioController {
    @Autowired
    private DetalleServicioService detalleServicioService;

    @GetMapping
    public ResponseEntity<List<DetalleServicio>> findAll() {
        List<DetalleServicio> detalleservicios = detalleServicioService.findAll();
        return ResponseEntity.ok(detalleservicios);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DetalleServicio> findById(@PathVariable Integer id) {
        DetalleServicio detalleservicio = detalleServicioService.findById(id);
        if (detalleservicio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(detalleservicio);
    }

    @PostMapping
    public ResponseEntity<DetalleServicio> save(@RequestBody DetalleServicio detalleservicio) {
        DetalleServicio savedDetalleServicio = detalleServicioService.save(detalleservicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedDetalleServicio);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DetalleServicio> update(@PathVariable Integer id, @RequestBody DetalleServicio detalleservicio) {
        DetalleServicio existingDetalleServicio = detalleServicioService.findById(id);
        if (existingDetalleServicio == null) {
            return ResponseEntity.notFound().build();
        }
        detalleservicio.setIdDetalle(id);
        DetalleServicio updatedDetalleServicio = detalleServicioService.save(detalleservicio);
        return ResponseEntity.ok(updatedDetalleServicio);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        DetalleServicio detalleservicio = detalleServicioService.findById(id);
        if (detalleservicio == null) {
            return ResponseEntity.notFound().build();
        }
        detalleServicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
