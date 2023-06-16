package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Pais> findById(@PathVariable Long id) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pais);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Pais> save(@RequestBody Pais pais) {
        Pais savedPais = paisService.save(pais);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPais);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Pais> update(@PathVariable Long id, @RequestBody Pais pais) {
        Pais existingPais = paisService.findById(id);
        if (existingPais == null) {
            return ResponseEntity.notFound().build();
        }
        pais.setIdPais(id);
        Pais updatedPais = paisService.save(pais);
        return ResponseEntity.ok(updatedPais);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Pais pais = paisService.findById(id);
        if (pais == null) {
            return ResponseEntity.notFound().build();
        }
        paisService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
