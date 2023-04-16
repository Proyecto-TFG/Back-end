package com.proyectoTFG.PoyectoTFG.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoTFG.PoyectoTFG.Security.JwtTokenUtil;
import com.proyectoTFG.PoyectoTFG.entities.AuthRequest;
import com.proyectoTFG.PoyectoTFG.entities.AuthResponse;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;

@RestController
public class AuthApi {
    
    @Autowired
    AuthenticationManager authManager;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @PostMapping("/auth/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) throws Exception {
        try {
            Authentication authentication = (Authentication) authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                        authRequest.getEmail(), authRequest.getPassword())
            );

            Usuario usuario = (Usuario) authentication.getPrincipal();
            String accessToken = jwtTokenUtil.generateAccessToken(usuario);
            AuthResponse response = new AuthResponse(usuario.getUsername(), accessToken);

            return ResponseEntity.ok().body(response);

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        
    }


}
