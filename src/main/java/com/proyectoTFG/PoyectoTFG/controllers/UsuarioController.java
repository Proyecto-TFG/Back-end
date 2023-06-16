package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.services.UsuarioService;



@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List <Usuario>> findAll() {
        List<Usuario> usuarios = usuarioService.findAll();
        return ResponseEntity.ok(usuarios);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/userName/{username}")
    public ResponseEntity<Usuario> findByUserName(@PathVariable String username) {
        Usuario usuario = usuarioService.findByUserName(username);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER')")
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(@PathVariable Long id) {
        Usuario usuario = usuarioService.findById(id);
        if (usuario == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(usuario);
    }


    /* @PostMapping
    @PreAuthorize("permitAll()")
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario, @RequestParam String tipo) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(usuario.getPassword());
        usuario.setPassword(encodedPassword);
        Usuario savedUsuario = usuarioService.save(usuario);

        Trabajador trabajador = new Trabajador();
        trabajador.setIdUsuario(savedUsuario.getId());
        trabajador.setTipo(tipo);
        trabajadorService.save(trabajador);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedUsuario);
    } */

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER')")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id, @RequestBody Usuario usuario) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuario.setId(id);
        Usuario updatedUsuario = usuarioService.save(usuario);
        return ResponseEntity.ok(updatedUsuario);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER')")
    @DeleteMapping("/{id}") 
    public ResponseEntity<Usuario> delete(@PathVariable Long id) {
        Usuario existingUsuario = usuarioService.findById(id);
        if (existingUsuario == null) {
            return ResponseEntity.notFound().build();
        }
        usuarioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{id}/hasRole/{roleName}")
    public ResponseEntity<?> hasRole(@PathVariable Long id, @PathVariable String roleName) {
        boolean hasRole = usuarioService.hasRole(id, roleName);
        return ResponseEntity.ok(hasRole);
    }
    
}
