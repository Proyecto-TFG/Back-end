package com.proyectoTFG.PoyectoTFG.entities;

public class CiudadConProvinciaYPaisDTO {

    private Long idCiudad;
    private String nombreCiudad;
    private String nombreProvincia;
    private String nombrePais;

    public CiudadConProvinciaYPaisDTO() {
    }

    public CiudadConProvinciaYPaisDTO(Long idCiudad, String nombreCiudad, String nombreProvincia, String nombrePais) {
        this.idCiudad = idCiudad;
        this.nombreCiudad = nombreCiudad;
        this.nombreProvincia = nombreProvincia;
        this.nombrePais = nombrePais;
    }
    public Long getIdCiudad() {
        return this.idCiudad;
    }

    public void setIdCiudad(Long idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getNombreProvincia() {
        return this.nombreProvincia;
    }

    public void setNombreProvincia(String nombreProvincia) {
        this.nombreProvincia = nombreProvincia;
    }

    public String getNombrePais() {
        return this.nombrePais;
    }

    public void setNombrePais(String nombrePais) {
        this.nombrePais = nombrePais;
    }


    public String getNombreCiudad() {
        return this.nombreCiudad;
    }

    public void setNombreCiudad(String nombreCiudad) {
        this.nombreCiudad = nombreCiudad;
    }


    
}
