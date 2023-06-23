package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.ArrayList;
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
import com.proyectoTFG.PoyectoTFG.entities.ServicioSolicitado;
import com.proyectoTFG.PoyectoTFG.entities.ServicioSolicitadoConDisponible;
import com.proyectoTFG.PoyectoTFG.services.ServicioDisponibleService;
import com.proyectoTFG.PoyectoTFG.services.ServicioSolicitadoService;

@RestController
@RequestMapping("/api/serviciosSolicitados")
public class ServicioSolicitadoController {

    @Autowired
    private ServicioSolicitadoService servicioSolicitadoService;

    @Autowired
    private ServicioDisponibleService servicioDisponibleService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER','ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<ServicioSolicitado>> findAll() {
        List<ServicioSolicitado> serviciosSolicitados = servicioSolicitadoService.findAll();
        return ResponseEntity.ok(serviciosSolicitados);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER','ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<ServicioSolicitado> findById(@PathVariable Long id) {
        ServicioSolicitado servicioSolicitado = servicioSolicitadoService.findById(id);
        if (servicioSolicitado == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(servicioSolicitado);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER',  'ROLE_ADMIN')")
    @GetMapping("/usuario/{id}")
    public ResponseEntity<List<ServicioSolicitadoConDisponible>> findAllByIdCliente(@PathVariable Long id) {
        List <ServicioSolicitadoConDisponible> servicioSolicitadoConDisponible = new ArrayList<>();
        List<ServicioSolicitado> serviciosSolicitados = servicioSolicitadoService.findAllByIdCliente(id);
        if (serviciosSolicitados == null) {
            return ResponseEntity.notFound().build();
        }
        
        serviciosSolicitados.forEach(servicioSolicitado -> {
            ServicioDisponible servicioDisponible = servicioDisponibleService.findById(servicioSolicitado.getIdServicioDisponible());
            ServicioSolicitadoConDisponible servicioSolicitadoConDisponibleAux= new ServicioSolicitadoConDisponible(servicioSolicitado, servicioDisponible);
            servicioSolicitadoConDisponible.add(servicioSolicitadoConDisponibleAux);
        });
        
        return ResponseEntity.ok(servicioSolicitadoConDisponible);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<ServicioSolicitado> save(@RequestBody ServicioSolicitado servicioSolicitado) {
        ServicioSolicitado savedServicioSolicitado = servicioSolicitadoService.save(servicioSolicitado);
        return ResponseEntity.ok(savedServicioSolicitado);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER',  'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<ServicioSolicitado> update(@PathVariable Long id, @RequestBody ServicioSolicitado servicioSolicitado) {
        ServicioSolicitado updatedServicioSolicitado = servicioSolicitadoService.findById(id);
        if (updatedServicioSolicitado == null) {
            return ResponseEntity.notFound().build();
        }

        servicioSolicitado.setIdServicioSolicitado(id);
        ServicioSolicitado savedServicioSolicitado = servicioSolicitadoService.save(servicioSolicitado);

        return ResponseEntity.ok(savedServicioSolicitado);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<ServicioSolicitado> delete(@PathVariable Long id) {
        ServicioSolicitado servicioSolicitado = servicioSolicitadoService.findById(id);
        if (servicioSolicitado == null) {
            return ResponseEntity.notFound().build();
        }
        servicioSolicitadoService.deleteById(id);
        return ResponseEntity.ok(servicioSolicitado);
    }
}
