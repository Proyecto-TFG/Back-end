package com.proyectoTFG.PoyectoTFG.entities;

public class RegistroRequest {

    private Usuario usuario;
    private String tipo;

    public RegistroRequest() {
    }

    public RegistroRequest(Usuario usuario, String tipo) {
        this.usuario = usuario;
        this.tipo = tipo;
    }


    public Usuario getUsuario() {
        return this.usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getTipo() {
        return this.tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
