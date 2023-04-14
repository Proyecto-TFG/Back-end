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

import com.proyectoTFG.PoyectoTFG.entities.Ciudad;
import com.proyectoTFG.PoyectoTFG.services.CiudadService;

@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
    
    @Autowired
    private CiudadService ciudadService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> findAll() {
        List<Ciudad> ciudades = ciudadService.findAll();
        return ResponseEntity.ok(ciudades);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> findById(@PathVariable Integer id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ciudad);
    }

    @PostMapping
    public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad) {
        Ciudad savedCiudad = ciudadService.save(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCiudad);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Integer id, @RequestBody Ciudad ciudad) {
        Ciudad existingCiudad = ciudadService.findById(id);
        if (existingCiudad == null) {
            return ResponseEntity.notFound().build();
        }
        ciudad.setIdCiudad(id);
        Ciudad updatedCiudad = ciudadService.save(ciudad);
        return ResponseEntity.ok(updatedCiudad);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad == null) {
            return ResponseEntity.notFound().build();
        }
        ciudadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
