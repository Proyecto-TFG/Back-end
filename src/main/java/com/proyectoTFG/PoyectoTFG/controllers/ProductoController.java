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

import com.proyectoTFG.PoyectoTFG.entities.Producto;
import com.proyectoTFG.PoyectoTFG.services.ProductoService;


@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    //private static final Logger logger = LoggerFactory.getLogger(ProductoController.class);

    @Autowired
    private ProductoService productoService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Producto>> findAll() {
        List<Producto> productos = productoService.findAll();
        return ResponseEntity.ok(productos);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> findById(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(producto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Producto> save(@RequestBody Producto producto) {
        //logger.debug("Recibiendo solicitud para guardar un producto: {}", producto);
        Producto savedProducto = productoService.save(producto);
        //logger.debug("Producto guardado: {}", savedProducto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedProducto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> update(@PathVariable Long id, @RequestBody Producto producto) {
        Producto existingProducto = productoService.findById(id);
        if (existingProducto == null) {
            return ResponseEntity.notFound().build();
        }
        producto.setIdProducto(id);
        Producto updatedProducto = productoService.save(producto);
        return ResponseEntity.ok(updatedProducto);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Producto producto = productoService.findById(id);
        if (producto == null) {
            return ResponseEntity.notFound().build();
        }
        productoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
