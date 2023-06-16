package com.proyectoTFG.PoyectoTFG.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRolRepository;
import com.proyectoTFG.PoyectoTFG.services.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{


    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private UsuarioRolRepository usuarioRolRepository;
    
    @Override
    //@Transactional
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public void deleteById(Long id) {

        usuarioRepository.deleteById(id);
    }


    @Override
    public Usuario findByUserName(String username) {
        Usuario usuario = usuarioRepository.findByUserName(username);
        if(usuario == null){
            return null;
        }else{
            return usuario;
        }
    }


    @Override
    public boolean hasRole(Long userId, String roleName) {
        List<Long> roleIdList = usuarioRolRepository.findRoleIdsByIdUsuario(userId);
        if(roleIdList.isEmpty()){
            return false;
        }

        List<String> roleNames = usuarioRolRepository.findRoleNamesByIds(roleIdList);

        return roleNames.contains(roleName);
    }
    
}
