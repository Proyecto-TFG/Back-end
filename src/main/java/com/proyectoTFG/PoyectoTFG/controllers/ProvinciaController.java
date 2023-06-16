package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.proyectoTFG.PoyectoTFG.entities.Provincia;
import com.proyectoTFG.PoyectoTFG.services.PaisService;
import com.proyectoTFG.PoyectoTFG.services.ProvinciaService;


@RestController
@RequestMapping("/api/provincias")
public class ProvinciaController {
    
    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Provincia>> findAll() {
        List<Provincia> provincias = provinciaService.findAll();
        return ResponseEntity.ok(provincias);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Provincia> findById(@PathVariable Long id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(provincia);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Provincia> save(@RequestBody Provincia provincia) {
        Provincia savedProvincia = provinciaService.save(provincia);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProvincia);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Provincia> update(@PathVariable Long id, @RequestBody Provincia provincia) {
        Provincia existingProvincia = provinciaService.findById(id);
        if (existingProvincia == null) {
            return ResponseEntity.notFound().build();
        }        
        Provincia updatedProvincia = provinciaService.save(provincia);
        return ResponseEntity.ok(updatedProvincia);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Provincia provincia = provinciaService.findById(id);
        if (provincia == null) {
            return ResponseEntity.notFound().build();
        }
        provinciaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    //provincia con nombrePais
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/conNombrePais/{idProvincia}")
    public ResponseEntity<Object> obtenerProvinciaConNombrePais(@PathVariable Long idProvincia){
        Provincia provincia = provinciaService.findById(idProvincia);
        Pais pais = paisService.findById(provincia.getIdPais());
        String nombrePais = pais.getNombre();

        Map<String, Object> provinciaConNombrePais = new HashMap<>();
        provinciaConNombrePais.put("provincia", provincia);
        provinciaConNombrePais.put("nombrePais", nombrePais);

        return ResponseEntity.ok(provinciaConNombrePais);
    }
}
