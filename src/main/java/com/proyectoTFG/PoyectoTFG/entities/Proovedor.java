package com.proyectoTFG.PoyectoTFG.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "proovedores")
public class Proovedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProovedor;

    @Column(nullable = false)
    private String NIF;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String direccion;

    @Column(nullable = false)
    private String telefono;

    @ManyToOne
    @JoinColumn(name = "idPais")
    private Pais pais;

    @ManyToOne
    @JoinColumn(name = "idCiudad")
    private Ciudad ciudad;

    @ManyToOne
    @JoinColumn(name = "idProvincia")
    private Provincia provincia;

    @Column(nullable = false)
    private String email;


    public Proovedor() {
    }


    public Proovedor(Integer idProovedor, String NIF, String nombre, String direccion, String telefono, Pais pais, Ciudad ciudad, Provincia provincia, String email) {
        this.idProovedor = idProovedor;
        this.NIF = NIF;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.pais = pais;
        this.ciudad = ciudad;
        this.provincia = provincia;
        this.email = email;
    }


    public Integer getIdProovedor() {
        return this.idProovedor;
    }

    public void setIdProovedor(Integer idProovedor) {
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

    public Pais getPais() {
        return this.pais;
    }

    public void setPais(Pais pais) {
        this.pais = pais;
    }

    public Ciudad getCiudad() {
        return this.ciudad;
    }

    public void setCiudad(Ciudad ciudad) {
        this.ciudad = ciudad;
    }

    public Provincia getProvincia() {
        return this.provincia;
    }

    public void setProvincia(Provincia provincia) {
        this.provincia = provincia;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
}
