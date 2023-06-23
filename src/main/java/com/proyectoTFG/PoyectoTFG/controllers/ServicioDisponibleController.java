package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.proyectoTFG.PoyectoTFG.entities.ServicioDisponible;
import com.proyectoTFG.PoyectoTFG.services.ServicioDisponibleService;

@RestController
@RequestMapping("/api/serviciosDisponibles")
public class ServicioDisponibleController {

    @Autowired
    private ServicioDisponibleService servicioDisponibleService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<ServicioDisponible>> findAll() {
        List<ServicioDisponible> serviciosDisponibles = servicioDisponibleService.findAll();
        return ResponseEntity.ok(serviciosDisponibles);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ServicioDisponible> findById(@PathVariable Long id) {
        ServicioDisponible servicioDisponible = servicioDisponibleService.findById(id);
        if (servicioDisponible == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicioDisponible);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ServicioDisponible> save(@RequestBody ServicioDisponible servicioDisponible) {
        ServicioDisponible savedServicioDisponible = servicioDisponibleService.save(servicioDisponible);
        return ResponseEntity.ok(savedServicioDisponible);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ServicioDisponible> update(@PathVariable Long id, @RequestBody ServicioDisponible servicioDisponible) {
        ServicioDisponible updatedServicioDisponible = servicioDisponibleService.findById(id);
        if (updatedServicioDisponible == null) {
            return ResponseEntity.notFound().build();
        }

        servicioDisponible.setIdServicioDisponible(id);
        ServicioDisponible savedServicioDisponible = servicioDisponibleService.save(servicioDisponible);
        return ResponseEntity.ok(savedServicioDisponible);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ServicioDisponible> deleteById(@PathVariable Long id) {
        servicioDisponibleService.deleteById(id);
        return ResponseEntity.ok(null);
    }
    

    
}
