package com.proyectoTFG.PoyectoTFG;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;

import com.proyectoTFG.PoyectoTFG.entities.Usuario;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
public class UserRepositoryTests {
    
    @Autowired
    private UsuarioRepository repo;

    @Test
    public void testCreateUser() {
     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
     String password = passwordEncoder.encode("123789654");

     Usuario user = new Usuario("gian@mail.com", password,"7777777777");
     Usuario savedUser = repo.save(user);

     assertThat(savedUser).isNotNull(); 
     assertThat(savedUser.getId()).isGreaterThan(0);       
    }

    @Test
    public void testCreateUser1() {
     BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
     String password = passwordEncoder.encode("123789654");

     Usuario user = new Usuario("giancarlo@mail.com", password,"888888888888");
     Usuario savedUser = repo.save(user);

     assertThat(savedUser).isNotNull(); 
     assertThat(savedUser.getId()).isGreaterThan(0);       
    }
}
