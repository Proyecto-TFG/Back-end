package com.proyectoTFG.PoyectoTFG.controllers;

import java.util.ArrayList;
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

import com.proyectoTFG.PoyectoTFG.entities.Trabajador;
import com.proyectoTFG.PoyectoTFG.entities.TrabajadorRol;
import com.proyectoTFG.PoyectoTFG.entities.UserTrabajadorDTO;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.services.ClienteService;
import com.proyectoTFG.PoyectoTFG.services.RolService;
import com.proyectoTFG.PoyectoTFG.services.TrabajadorService;
import com.proyectoTFG.PoyectoTFG.services.UsuarioRolService;
import com.proyectoTFG.PoyectoTFG.services.UsuarioService;



@RestController
@RequestMapping("/api/trabajadores")
public class TrabajadorController {
    @Autowired
    private TrabajadorService trabajadorService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private UsuarioRolService usuarioRolService;

    @Autowired
    private RolService rolService;

    @Autowired 
    private ClienteService clienteService;

    
    @GetMapping
    public ResponseEntity<List<Trabajador>> findAll() {
        List<Trabajador> trabajadores = trabajadorService.findAll();
        return ResponseEntity.ok(trabajadores);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping("/{idTrabajador}")
    public ResponseEntity<UserTrabajadorDTO> findById(@PathVariable Long idTrabajador) {
        Trabajador trabajador = trabajadorService.findById(idTrabajador);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }

        Usuario usuario = usuarioService.findById(trabajador.getIdUsuario());
        UserTrabajadorDTO userTrabajadorDTO = new UserTrabajadorDTO();

        //obtener roles de trabajador
        List<Long> listaRoles = new ArrayList<>();
        List<UsuarioRol> usuarioRoles = usuarioRolService.findByUsuarioId(trabajador.getIdUsuario());
        usuarioRoles.forEach(usuarioRol -> {
            listaRoles.add(usuarioRol.getRol());
        });
        userTrabajadorDTO.setRoles(listaRoles);
        
        userTrabajadorDTO.setTrabajador(trabajador);
        userTrabajadorDTO.setUsuario(usuario);

        return ResponseEntity.ok(userTrabajadorDTO);
    }


    //obtener trabajadores por id de usuario
    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Trabajador> findByIdUsuario(@PathVariable Long idUsuario) {
       Trabajador trabajador = trabajadorService.obtenerTrabajadorPorIdUsuario(idUsuario);
       if(trabajador == null) {
           return ResponseEntity.notFound().build();
       }
        return ResponseEntity.ok(trabajador);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Trabajador> save(@RequestBody TrabajadorRol trabajadorRol) {
        System.out.println("TRABAJADOR : " + trabajadorRol.getTrabajador().toString());
        Trabajador trabajador = trabajadorRol.getTrabajador();
        Usuario usuario = usuarioService.findById(trabajadorRol.getTrabajador().getIdUsuario());
        List<Long> roles = trabajadorRol.getRoles();

        //eliminar roles previamente
        usuarioRolService.deleteAllByIdUsuario(usuario.getId());

        //guardar roles
        roles.forEach(rolId -> {
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setRol(rolId);
            usuarioRol.setUsuario(usuario.getId());
            this.usuarioRolService.save(usuarioRol);
        });

        //eliminar cliente
        clienteService.deleteByIdUsuario(usuario.getId());

        Trabajador savedTrabajador = trabajadorService.save(trabajador);
        
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTrabajador);
    }

    @PreAuthorize("hasAnyRole('ROLE_ADMIN')")
    @PutMapping("/trabajador/{idTrabajador}/usuario/{idUsuario}")
    public ResponseEntity<Trabajador> update(@PathVariable Long idTrabajador,@PathVariable Long idUsuario, @RequestBody UserTrabajadorDTO userTrabajador) {
        
        //obtener usuario y trabajador y roles
        Trabajador trabajador = userTrabajador.getTrabajador();
        Usuario usuario = userTrabajador.getUsuario();
        List<Long> listRolesTrabajador = userTrabajador.getRoles();


       
        //borrar roles antiguos
        usuarioRolService.deleteAllByIdUsuario(idUsuario);

        //guardar roles
        listRolesTrabajador.forEach(rolId -> {
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setRol(rolId);
            usuarioRol.setUsuario(usuario.getId());
            this.usuarioRolService.save(usuarioRol);
        });    

        //actualizar usuario y trabajador
        usuario.setId(idUsuario);
        usuarioService.save(usuario);
        trabajador.setIdTrabajador(idTrabajador);
        Trabajador updatedTrabajador = trabajadorService.save(trabajador);
        return ResponseEntity.ok(updatedTrabajador);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Trabajador trabajador = trabajadorService.findById(id);
        if (trabajador == null) {
            return ResponseEntity.notFound().build();
        }
        trabajadorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    

    
}
