package com.proyectoTFG.PoyectoTFG.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name = "compras")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCompra;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false)
    private Integer cantidad;

    @Column(nullable = false)
    private Double precioUnidad;

    @Column(nullable = false)
    private Double total;

    @JoinColumn(name = "idProovedor")
    private Long idProovedor;

    @JoinColumn(name = "idProducto")
    private Long idProducto;

    @JoinColumn(name = "idTrabajador")
    private Long idTrabajador;


    public Compra() {
    }

    public Compra( Date fecha, Integer cantidad, Double precioUnidad, Double total, Long idProovedor, Long idProducto, Long idTrabajador) {
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.precioUnidad = precioUnidad;
        this.total = total;
        this.idProovedor = idProovedor;
        this.idProducto = idProducto;
        this.idTrabajador = idTrabajador;
    }


    public Long getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Long idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return this.cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getPrecioUnidad() {
        return this.precioUnidad;
    }

    public void setPrecioUnidad(Double precioUnidad) {
        this.precioUnidad = precioUnidad;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Long getIdProovedor() {
        return this.idProovedor;
    }

    public void setIdProovedor(Long idProovedor) {
        this.idProovedor = idProovedor;
    }

    public Long getIdProducto() {
        return this.idProducto;
    }

    public void setIdProducto(Long idProducto) {
        this.idProducto = idProducto;
    }


    public Long getIdTrabajador() {
        return this.idTrabajador;
    }

    public void setIdTrabajador(Long idTrabajador) {
        this.idTrabajador = idTrabajador;
    }


    
}
