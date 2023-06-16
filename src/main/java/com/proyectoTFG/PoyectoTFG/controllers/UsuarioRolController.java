package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.services.UsuarioRolService;



@RestController
@RequestMapping("/api/usuarioRol")
public class UsuarioRolController {

    @Autowired
    private UsuarioRolService usuarioRolService;
    

    @GetMapping
    public ResponseEntity<List <UsuarioRol>> findAll() {
        List<UsuarioRol> usuarioRol = usuarioRolService.findAll();
        return ResponseEntity.ok(usuarioRol);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioRol> findById(@PathVariable Long id) {
        UsuarioRol usuarioRol = usuarioRolService.findById(id);
        if (usuarioRol == null) {
            System.out.println("No se ha encontrado el usuarioRol");
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuarioRol);
    }

    @PostMapping
    public ResponseEntity<UsuarioRol> save(@RequestBody UsuarioRol usuarioRol) {
        usuarioRolService.save(usuarioRol);
        return ResponseEntity.status(201).body(usuarioRol);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioRol> update(@PathVariable Long id, @RequestBody UsuarioRol usuarioRol) {
        UsuarioRol existingUsuarioRol = usuarioRolService.findById(id);
        if (existingUsuarioRol == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioRol.setId(id);
        usuarioRolService.save(usuarioRol);
        return ResponseEntity.ok(usuarioRol);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UsuarioRol> deleteById(@PathVariable Long id) {
        UsuarioRol usuarioRol = usuarioRolService.findById(id);
        if (usuarioRol == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioRolService.deleteById(id);
        return ResponseEntity.ok(usuarioRol);
    }
}
