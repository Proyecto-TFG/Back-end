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

import com.proyectoTFG.PoyectoTFG.entities.Compra;
import com.proyectoTFG.PoyectoTFG.entities.Producto;
import com.proyectoTFG.PoyectoTFG.services.CompraService;
import com.proyectoTFG.PoyectoTFG.services.ProductoService;

@RestController
@RequestMapping("/api/compras")
public class CompraController {
    @Autowired
    private CompraService compraService;

    @Autowired
    private ProductoService productoService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Compra>> findAll() {
        List<Compra> compras = compraService.findAll();
        return ResponseEntity.ok(compras);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Compra> findById(@PathVariable Long id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(compra);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Compra> save(@RequestBody Compra compra) {
        Double precioTotal = compra.getCantidad() * compra.getPrecioUnidad();
        compra.setTotal(precioTotal);
        //actualizar el stock del producto
        Producto producto = productoService.findById(compra.getIdProducto());
        Integer existencias = producto.getExistencias() + compra.getCantidad();
        producto.setExistencias(existencias);
        productoService.save(producto);
        Compra savedCompra = compraService.save(compra);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedCompra);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Compra> update(@PathVariable Long id, @RequestBody Compra compra) {
        Compra existingCompra = compraService.findById(id);
        if (existingCompra == null) {
            return ResponseEntity.notFound().build();
        }
        Double precioTotal = compra.getCantidad() * compra.getPrecioUnidad();
        compra.setTotal(precioTotal);
        compra.setIdCompra(id);
        //actualizar el stock del producto
        Producto producto = productoService.findById(compra.getIdProducto());
        Integer existencias = producto.getExistencias() + compra.getCantidad();
        producto.setExistencias(existencias);
        productoService.save(producto);
        Compra updatedCompra = compraService.save(compra);
        return ResponseEntity.ok(updatedCompra);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Compra compra = compraService.findById(id);
        if (compra == null) {
            return ResponseEntity.notFound().build();
        }
        compraService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
