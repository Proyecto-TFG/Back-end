package com.proyectoTFG.PoyectoTFG.Security;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.proyectoTFG.PoyectoTFG.entities.Rol;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.repositories.RolRepository;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtTokenFilter extends OncePerRequestFilter{

    @Autowired
    private RolRepository rolRepository;

    @Autowired
    private JwtTokenUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

                if (!hasAuthorizationBearer(request)) {
                    filterChain.doFilter(request, response);
                    return;
                }

                String token = getAccessToken(request);
                
                if (!jwtUtil.validateAccessToken(token)) {
                    filterChain.doFilter(request, response);
                    return;
                }
                
                setAuthenticationContext(token, request);
                filterChain.doFilter(request, response);
    }

    private boolean hasAuthorizationBearer(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (ObjectUtils.isEmpty(header) || !header.startsWith("Bearer")) {
            return false;
        }
        return true;
    }

    private String getAccessToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        String token = header.split(" ")[1].trim();
        return token;
    }

    private void setAuthenticationContext(String token, HttpServletRequest request) {
       UserDetails userDetails = getUserDetails(token);

       UsernamePasswordAuthenticationToken
         authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());

        authentication.setDetails(
            new WebAuthenticationDetailsSource().buildDetails(request));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    private UserDetails getUserDetails(String token) {
        System.out.println("Token: " + token);
        Usuario userDetails = new Usuario();
        Claims claims = jwtUtil.parseClaims(token);
        System.out.println("Tipo de claims.get('roles'): " + claims.get("roles").getClass().getName());
        System.out.println("Contenido de roles: " + claims.get("roles"));
        String subject = (String) claims.get(Claims.SUBJECT);
        List<String> roles = (List<String>) claims.get("roles");


        
        

        for (String roleName: roles){
            Rol role = rolRepository.findByNombre(roleName);
            System.out.println("El rol " + roleName + " se encontró en la base de datos.");
            if(role != null){
                UsuarioRol userRole = new UsuarioRol(userDetails, role);
                userDetails.addRol(userRole);
            }else{
                System.out.println("El rol " + roleName + " no se encontró en la base de datos.");
            }
        }

        /* 
        System.out.println("Valor de roles en el token: " + roles);

        roles = roles.replace("[", "").replace("]", "");

        System.out.println("Roles sin corchetes: " + roles);

        String[] roleNames = roles.split(",");

        System.out.println("Nombres de roles: ");
        for (String aRoleName: roleNames) {
            //userDetails.addRol(new Rol(aRoleName));
            System.out.println("- "+aRoleName);
            Rol role = rolRepository.findByNombre(aRoleName);
            
            if(role != null){
                UsuarioRol userRole = new UsuarioRol(userDetails, role);
                userDetails.addRol(userRole);
            }else {
                System.out.println("El rol " + aRoleName + " no se encontró en la base de datos.");
            }
            
            
        }*/

        String[] jwtSubject = subject.split(",");

        
        
        userDetails.setId(Long.parseLong(jwtSubject[0]));
        userDetails.setUserName(jwtSubject[1]);
        return userDetails;
    }
}