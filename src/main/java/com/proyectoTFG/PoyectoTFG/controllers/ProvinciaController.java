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

import com.proyectoTFG.PoyectoTFG.entities.Provincia;
import com.proyectoTFG.PoyectoTFG.services.ProvinciaService;

@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @GetMapping
    public ResponseEntity<List<Provincia>> findAll() {
        List<Provincia> provincias = provinciaService.findAll();
        return ResponseEntity.ok(provincias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Provincia> findById(@PathVariable Integer id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(provincia);
    }

    @PostMapping
    public ResponseEntity<Provincia> save(@RequestBody Provincia provincia) {
        Provincia savedProvincia = provinciaService.save(provincia);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProvincia);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Provincia> update(@PathVariable Integer id, @RequestBody Provincia provincia) {
        Provincia existingProvincia = provinciaService.findById(id);
        if (existingProvincia == null) {
            return ResponseEntity.notFound().build();
        }
        provincia.setIdProvincia(id);
        Provincia updatedProvincia = provinciaService.save(provincia);
        return ResponseEntity.ok(updatedProvincia);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return ResponseEntity.notFound().build();
        }
        provinciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
