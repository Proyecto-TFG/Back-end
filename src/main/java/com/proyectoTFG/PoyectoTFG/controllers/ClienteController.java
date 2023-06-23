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

import com.proyectoTFG.PoyectoTFG.entities.Cliente;
import com.proyectoTFG.PoyectoTFG.entities.UserClienteDTO;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.services.ClienteService;
import com.proyectoTFG.PoyectoTFG.services.UsuarioService;



@RestController
@RequestMapping("/api/clientes")
public class ClienteController {
    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioService usuarioService;

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @GetMapping
    public ResponseEntity<List<Cliente>> findAll() {
        List<Cliente> clientes = clienteService.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER', 'ROLE_ADMIN')")
    @GetMapping("/{idCliente}")
    public ResponseEntity<UserClienteDTO> findById(@PathVariable Long idCliente) {
        Cliente cliente = clienteService.findById(idCliente);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        Usuario usuario = usuarioService.findById(cliente.getIdUsuario());
        UserClienteDTO userClienteDTO = new UserClienteDTO();
        userClienteDTO.setCliente(cliente);
        userClienteDTO.setUsuario(usuario);

        return ResponseEntity.ok(userClienteDTO);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_USER','ROLE_ADMIN')")
    @GetMapping("/usuario/{idUsuario}")
    public ResponseEntity<Cliente> findByIdUsuario(@PathVariable Long idUsuario) {
        Cliente cliente = clienteService.findByIdUsuario(idUsuario);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cliente);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @PutMapping("/cliente/{idCliente}/usuario/{idUsuario}")
    public ResponseEntity<Cliente> update(@PathVariable Long idCliente, @PathVariable Long idUsuario, @RequestBody UserClienteDTO userClienteDTO) {
        //obtener usuario y cliente
        Cliente cliente = userClienteDTO.getCliente();
        Usuario usuario = userClienteDTO.getUsuario();

        //actualizar usuario y cliente
        usuario.setId(idUsuario);
        usuarioService.save(usuario);
        cliente.setIdCliente(idCliente);

        Cliente updatedCliente = clienteService.save(cliente);
        return ResponseEntity.ok(updatedCliente);
    }

    @PreAuthorize("hasAnyRole('ROLE_MANAGER', 'ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        Cliente cliente = clienteService.findById(id);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
