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

import com.proyectoTFG.PoyectoTFG.entities.Trabajador;
import com.proyectoTFG.PoyectoTFG.services.TrabajadorService;

@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @GetMapping
    public ResponseEntity<List<Trabajador>> findAll() {
        List<Trabajador> trabajadores = trabajadorService.findAll();
        return ResponseEntity.ok(trabajadores);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> findById(@PathVariable Integer id) {
        Trabajador trabajador = trabajadorService.findById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(trabajador);
    }

    @PostMapping
    public ResponseEntity<Trabajador> save(@RequestBody Trabajador trabajador) {

        Trabajador savedTrabajador = trabajadorService.save(trabajador);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> update(@PathVariable Integer id, @RequestBody Trabajador trabajador) {
        Trabajador existingTrabajador = trabajadorService.findById(id);
        if (existingTrabajador == null) {
            return ResponseEntity.notFound().build();
        }
        trabajador.setIdTrabajador(id);
        Trabajador updatedTrabajador = trabajadorService.save(trabajador);
        return ResponseEntity.ok(updatedTrabajador);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id) {
        Trabajador trabajador = trabajadorService.findById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }
        trabajadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
