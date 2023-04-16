package com.proyectoTFG.PoyectoTFG;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.proyectoTFG.PoyectoTFG.entities.Rol;
import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.repositories.RolRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class RoleRepositoryTests {

    @Autowired
    private RolRepository repo;

    @Autowired
    private UsuarioRepository userRepo;

    @Test
    public void testCreateRoles() {
        Rol roleAdmin = new Rol("ROLE_ADMIN");
        Rol roleUser = new Rol("ROLE_USER");
        Rol roleManager = new Rol("ROLE_MANAGER");
        repo.saveAll(List.of(roleAdmin, roleUser, roleManager));

        long count = repo.count();
        assertEquals(3, count);
    }

    @Test
    public void testAssignRoleToUser() {
        Long userId = 1L;
        Long roleId = 2L;
        Usuario user = userRepo.findById(userId).get();
        user.addRol(new Rol(roleId));

        Usuario updateUser = userRepo.save(user);
        assertThat(updateUser.getRoles()).hasSize(1);
    }

    @Test
    public void testAssignRoleToUser1() {
        Long userId = 2L;
        Usuario user = userRepo.findById(userId).get();
        user.addRol(new Rol(1L));
        user.addRol(new Rol(2L));

        Usuario updatedUser = userRepo.save(user);
        assertThat(updatedUser.getRoles()).hasSize(2);

    }
}
