package com.proyectoTFG.PoyectoTFG.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyectoTFG.PoyectoTFG.entities.UsuarioRol;

public interface UsuarioRolRepository extends JpaRepository<UsuarioRol, Long>{
    List<UsuarioRol> findByIdUsuario(Long idUsuario);

    @Query("SELECT ur.rol FROM UsuarioRol ur WHERE ur.idUsuario = :userId")
    List<Long> findRoleIdsByIdUsuario(@Param("userId") Long userId);

    @Query("SELECT r.nombre FROM Rol r WHERE r.id IN :roleIds")
    List<String> findRoleNamesByIds(@Param("roleIds") List<Long> roleIds);

    void deleteAllByIdUsuario(Long idUsuario);
    
}
