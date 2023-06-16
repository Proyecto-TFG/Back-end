package com.proyectoTFG.PoyectoTFG.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
@Entity
@Table(name = "proovedores")
public class Proovedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProovedor;

    @Column(nullable = false)
    private String NIF;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @JoinColumn(name = "idPais")
    private Long idPais;

    @JoinColumn(name = "idCiudad")
    private Long idCiudad;

    @JoinColumn(name = "idProvincia")
    private Long idProvincia;

    @Column(unique = true)
    @Email(message = "El email no es valido")
    private String email;


    public Proovedor() {
    }

    public Proovedor(String NIF, String nombre, String direccion, String telefono, Long idPais, Long idCiudad, Long idProvincia, String email) {
        this.NIF = NIF;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.idPais = idPais;
        this.idCiudad = idCiudad;
        this.idProvincia = idProvincia;
        this.email = email;
    }


    public Long getIdProovedor() {
        return this.idProovedor;
    }

    public void setIdProovedor(Long idProovedor) {
        this.idProovedor = idProovedor;
    }

    public String getNIF() {
        return this.NIF;
    }

    public void setNIF(String NIF) {
        this.NIF = NIF;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Long getIdPais() {
        return this.idPais;
    }

    public void setIdPais(Long idPais) {
        this.idPais = idPais;
    }

    public Long getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public Long getIdProvincia() {
        return this.idProvincia;
    }

    public void setIdProvincia(Long idProvincia) {
        this.idProvincia = idProvincia;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    
    
}
