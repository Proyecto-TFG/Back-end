package com.proyectoTFG.PoyectoTFG.entities;



public class DetalleCompra {

    private Compra compra;
    private Producto producto;
    private Trabajador trabajador;
    private Proovedor proovedor;

    public DetalleCompra() {
    }

    public DetalleCompra(Compra compra, Producto producto, Trabajador trabajador, Proovedor proovedor) {
        this.compra = compra;
        this.producto = producto;
        this.trabajador = trabajador;
        this.proovedor = proovedor;
    }


    public Compra getCompra() {
        return this.compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return this.producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Trabajador getTrabajador() {
        return this.trabajador;
    }

    public void setTrabajador(Trabajador trabajador) {
        this.trabajador = trabajador;
    }

    public Proovedor getProovedor() {
        return this.proovedor;
    }

    public void setProovedor(Proovedor proovedor) {
        this.proovedor = proovedor;
    }


    
}
