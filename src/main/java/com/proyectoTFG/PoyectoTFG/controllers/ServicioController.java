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

import com.proyectoTFG.PoyectoTFG.entities.Servicio;
import com.proyectoTFG.PoyectoTFG.services.ServicioService;


@RestController
@RequestMapping("/api/servicios")
public class ServicioController {
    @Autowired
    private ServicioService servicioService;    

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Servicio>> findAll() {
        List<Servicio> servicios = servicioService.findAll();
        return ResponseEntity.ok(servicios);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Servicio> findById(@PathVariable Integer id) {
        Servicio servicio = servicioService.findById(id);
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicio);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/usuario/{idCliente}") 
    public ResponseEntity<List<Servicio>> findAllByIdCliente(@PathVariable Long idCliente){
        List<Servicio> servicios = servicioService.findAllByIdCliente(idCliente);

        return ResponseEntity.ok(servicios);
    }




    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Servicio> save(@RequestBody Servicio servicio) {
        Servicio savedServicio = servicioService.save(servicio);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedServicio);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Servicio> update(@PathVariable Integer id, @RequestBody Servicio servicio) {
        Servicio existingServicio = servicioService.findById(id);
        if (existingServicio == null) {
            return ResponseEntity.notFound().build();
        }
        servicio.setIdServicio(id);
        Servicio updatedServicio = servicioService.save(servicio);
        return ResponseEntity.ok(updatedServicio);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Servicio servicio = servicioService.findById(id);
        if (servicio == null) {
            return ResponseEntity.notFound().build();
        }
        servicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
