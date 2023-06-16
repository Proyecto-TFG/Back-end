package com.proyectoTFG.PoyectoTFG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.Security.JwtTokenUtil;
import com.proyectoTFG.PoyectoTFG.entities.AuthRequest;
import com.proyectoTFG.PoyectoTFG.entities.AuthResponse;
import com.proyectoTFG.PoyectoTFG.entities.Cliente;
import com.proyectoTFG.PoyectoTFG.entities.CustomUserDetails;
import com.proyectoTFG.PoyectoTFG.entities.RegistroRequest;
import com.proyectoTFG.PoyectoTFG.entities.Trabajador;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRolRepository;
import com.proyectoTFG.PoyectoTFG.services.ClienteService;
import com.proyectoTFG.PoyectoTFG.services.TrabajadorService;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private TrabajadorService trabajadorService;

    @Autowired
    private ClienteService clienteService;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {

        try {

            UserDetails userDetails = userDetailsService.loadUserByUsername(authRequest.getUserName());
            String token = jwtTokenUtil.generateToken(userDetails);

            AuthResponse authResponse = new AuthResponse(token);

            return ResponseEntity.ok(authResponse);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales incorrectas");
        }

    }

    @PostMapping("/registro")
    public ResponseEntity<?> registro(@RequestBody RegistroRequest request){

        System.out.println("Request: " + request.toString());

        Usuario usuario = request.getUsuario();
        String tipo = request.getTipo();

        //verificare si el usuario existe
        if(usuarioRepository.existsByUserName(usuario.getUserName())){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("El usuario ya existe");
        }

        // Codificar la contraseña del usuario
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String password = bCryptPasswordEncoder.encode(usuario.getPassword());
        usuario.setPassword(password);

        // Guardar el nuevo usuario en la base de datos
        Usuario savedUsuario = usuarioRepository.save(usuario);

        //Crear trabajador
        if(!tipo.isEmpty()){
            Trabajador trabajador = new Trabajador();
            trabajador.setIdUsuario(savedUsuario.getId());
            trabajador.setTipo(tipo);
            trabajadorService.save(trabajador);
            //Asignamos rol por defecto "ROLE_MANAGER"
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(savedUsuario.getId());
            usuarioRol.setRol(2L);
            usuarioRolRepository.save(usuarioRol);
        }//Crear cliente
        else{
            Cliente cliente = new Cliente();
            cliente.setIdUsuario(savedUsuario.getId());
            clienteService.save(cliente);
            //Asignamos rol por defecto "ROLE_USER"
            UsuarioRol usuarioRol = new UsuarioRol();
            usuarioRol.setUsuario(savedUsuario.getId());
            usuarioRol.setRol(3L);
            usuarioRolRepository.save(usuarioRol);
        }

        CustomUserDetails customUserDetails = new CustomUserDetails(savedUsuario);
    

        // Generar el token JWT utilizando los detalles del usuario
        String token = jwtTokenUtil.generateToken(customUserDetails);

        // Crear la respuesta de registro con el token
        AuthResponse authResponse = new AuthResponse(token);

        return ResponseEntity.ok(authResponse);

    }

}
