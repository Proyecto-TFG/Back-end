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

import com.proyectoTFG.PoyectoTFG.entities.Ciudad;
import com.proyectoTFG.PoyectoTFG.entities.CiudadConProvinciaYPaisDTO;
import com.proyectoTFG.PoyectoTFG.entities.Pais;
import com.proyectoTFG.PoyectoTFG.entities.Provincia;
import com.proyectoTFG.PoyectoTFG.services.CiudadService;
import com.proyectoTFG.PoyectoTFG.services.PaisService;
import com.proyectoTFG.PoyectoTFG.services.ProvinciaService;



@RestController
@RequestMapping("/api/ciudades")
public class CiudadController {
    
    @Autowired
    private CiudadService ciudadService;

    @Autowired
    private ProvinciaService provinciaService;

    @Autowired
    private PaisService paisService;

    @GetMapping
    public ResponseEntity<List<Ciudad>> findAll() {
        List<Ciudad> ciudades = ciudadService.findAll();
        return ResponseEntity.ok(ciudades);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Ciudad> findById(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ciudad);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Ciudad> save(@RequestBody Ciudad ciudad) {
        Ciudad savedCiudad = ciudadService.save(ciudad);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCiudad);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Ciudad> update(@PathVariable Long id, @RequestBody Ciudad ciudad) {
        Ciudad existingCiudad = ciudadService.findById(id);
        if (existingCiudad == null) {
            return ResponseEntity.notFound().build();
        }
        ciudad.setIdCiudad(id);
        Ciudad updatedCiudad = ciudadService.save(ciudad);
        return ResponseEntity.ok(updatedCiudad);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Ciudad ciudad = ciudadService.findById(id);
        if (ciudad == null) {
            return ResponseEntity.notFound().build();
        }
        ciudadService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/conProYPais/{idCiudad}")
    public ResponseEntity<Object> obtenerCiudadConProvinciaYPais(@PathVariable Long idCiudad) {
        Ciudad ciudad = ciudadService.findById(idCiudad);
        Provincia provincia = provinciaService.findById(ciudad.getIdProvincia());
        Pais pais = paisService.findById(provincia.getIdPais());

        CiudadConProvinciaYPaisDTO ciudadDTO = new CiudadConProvinciaYPaisDTO();
        ciudadDTO.setIdCiudad(ciudad.getIdCiudad());
        ciudadDTO.setNombreProvincia(provincia.getNombre());
        ciudadDTO.setNombrePais(pais.getNombre());
        ciudadDTO.setNombreCiudad(ciudad.getNombre());

        return ResponseEntity.ok(ciudadDTO);
    }

}
