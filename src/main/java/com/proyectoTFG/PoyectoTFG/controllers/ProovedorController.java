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

import com.proyectoTFG.PoyectoTFG.entities.Proovedor;
import com.proyectoTFG.PoyectoTFG.services.ProovedorService;

@RestController
@RequestMapping("/api/proovedores")
public class ProovedorController {
    @Autowired
    private ProovedorService proovedorService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Proovedor>> findAll() {
        List<Proovedor> proovedores = proovedorService.findAll();
        return ResponseEntity.ok(proovedores);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Proovedor> findById(@PathVariable Long id) {
        Proovedor proovedor = proovedorService.findById(id);
        if (proovedor == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(proovedor);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Proovedor> save(@RequestBody Proovedor proovedor) {
        Proovedor savedProovedor = proovedorService.save(proovedor);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProovedor);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Proovedor> update(@PathVariable Long id, @RequestBody Proovedor proovedor) {
        Proovedor existingProovedor = proovedorService.findById(id);
        if (existingProovedor == null) {
            return ResponseEntity.notFound().build();
        }
        proovedor.setIdProovedor(id);
        Proovedor updatedProovedor = proovedorService.save(proovedor);
        return ResponseEntity.ok(updatedProovedor);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Proovedor proovedor = proovedorService.findById(id);
        if (proovedor == null) {
            return ResponseEntity.notFound().build();
        }
        proovedorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
