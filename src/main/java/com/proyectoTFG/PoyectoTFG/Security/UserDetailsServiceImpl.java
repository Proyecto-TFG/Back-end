package com.proyectoTFG.PoyectoTFG.Security;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Rol;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;
import com.proyectoTFG.PoyectoTFG.repositories.RolRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRolRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;

    @Autowired
    private RolRepository rolRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByUserName(username);

        if(usuario == null){
            throw new UsernameNotFoundException("Usuario no encontrado");        }

        List <UsuarioRol> usuarioRoles =  usuarioRolRepository.findByIdUsuario(usuario.getId());

        List<Rol> roles = usuarioRoles.stream()
            .map(usuarioRol -> rolRepository.findById(usuarioRol.getRol())
            .orElseThrow(() -> new RuntimeException("Rol no encontrado")))
            .collect(Collectors.toList());

        List<GrantedAuthority> authorities = roles.stream()
            .map(rol ->new SimpleGrantedAuthority(rol.getNombre()))
            .collect(Collectors.toList());

        return new User(usuario.getUserName(), usuario.getPassword(), authorities);
        
    }
    
}
