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

import com.proyectoTFG.PoyectoTFG.entities.Pais;
import com.proyectoTFG.PoyectoTFG.services.PaisService;

@RestController
@RequestMapping("/api/paises")
public class PaisController {
    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Pais>> findAll() {
        List<Pais> paises = paisService.findAll();
        return ResponseEntity.ok(paises);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable Integer id) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pais);
    }

    @PostMapping
    public ResponseEntity<Pais> save(@RequestBody Pais pais) {
        Pais savedPais = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pais> update(@PathVariable Integer id, @RequestBody Pais pais) {
        Pais existingPais = paisService.findById(id);
        if (existingPais == null) {
            return ResponseEntity.notFound().build();
        }
        pais.setIdPais(id);
        Pais updatedPais = paisService.save(pais);
        return ResponseEntity.ok(updatedPais);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        paisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
