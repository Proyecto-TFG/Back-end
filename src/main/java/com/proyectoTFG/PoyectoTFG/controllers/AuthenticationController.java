package com.proyectoTFG.PoyectoTFG.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.Security.JwtUtils;
import com.proyectoTFG.PoyectoTFG.entities.JwtRequest;
import com.proyectoTFG.PoyectoTFG.entities.JwtResponse;
import com.proyectoTFG.PoyectoTFG.services.impl.UserDetailsServiceImpl;

@RestController
@CrossOrigin("*")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtTokenUtils;

    @PostMapping("/generate-token")
    public ResponseEntity<?> generateToken(@RequestBody JwtRequest jwtRequest) throws Exception {
        System.out.println("ENTRA EN GENERATE TOKEN");
        System.out.println("USERNAME: " + jwtRequest.getUsername());
        System.out.println("PASSWORD: " + jwtRequest.getPassword());
        try {
            authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception("Usuario no encontrado");
        } 

        UserDetails userDetails = this.userDetailsService.loadUserByUsername(jwtRequest.getUsername());
        String token = this.jwtTokenUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

        } catch (DisabledException disabledException) {
            throw new Exception("USUARIO DESHABILITADO " + disabledException.getMessage());
        }catch(BadCredentialsException badCredentialsException) {
            throw new Exception("CREDENCIALES INCORRECTAS " + badCredentialsException.getMessage());
        }

    }
    
}
