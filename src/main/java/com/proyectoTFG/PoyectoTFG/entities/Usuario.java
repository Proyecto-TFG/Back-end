package com.proyectoTFG.PoyectoTFG.entities;


import com.proyectoTFG.PoyectoTFG.repositories.RolRepository;
import com.proyectoTFG.PoyectoTFG.repositories.UsuarioRolRepository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    @Email(message = "El email no es valido")
    private String userName;

    @NotNull
    @Size(min = 8, message = "La contraseña debe tener al menos 8 caracteres")
    private String password;

    @Column(nullable = false)
    private String dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String telefono;

    @Column
    private String direccion;

    @Column(name = "idPais")
    private Long pais;

    @Column(name = "idCiudad")
    private Long ciudad;

    @Column(name = "idProvincia")
    private Long provincia;

    @Transient
    private UsuarioRolRepository usuarioRolRepository;

    @Transient
    private RolRepository rolRepository;

    public Usuario() {
    }


    public Usuario(String userName, String password, String dni, String nombre, String apellido, String telefono, String direccion, Long pais, Long ciudad, Long provincia) {
        this.userName = userName;
        this.password = password;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.direccion = direccion;
        this.pais = pais;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }


    public Usuario(String userName, String password, String dni) {
        this.userName = userName;
        this.password = password;
        this.dni = dni;
    }



    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }


    public Long getPais() {
        return this.pais;
    }

    public void setPais(Long pais) {
        this.pais = pais;
    }

    public Long getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(Long ciudad) {
        this.ciudad = ciudad;
    }

    public Long getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Long provincia) {
        this.provincia = provincia;
    }


    public void setUsuarioRolRepository(UsuarioRolRepository usuarioRolRepository) {
        this.usuarioRolRepository = usuarioRolRepository;
    }

    public void setRolRepository(RolRepository rolRepository) {
        this.rolRepository = rolRepository;
    }

}