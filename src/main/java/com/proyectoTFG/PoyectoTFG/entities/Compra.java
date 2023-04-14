package com.proyectoTFG.PoyectoTFG.entities;

import java.sql.Date;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "compras")
public class Compra {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCompra;

    @Column(nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fecha;

    @Column(nullable = false)
    private Double total;

    @ManyToOne
    @JoinColumn(name = "idProovedor")
    private Proovedor proovedor;

    @OneToMany(mappedBy = "compra", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<DetalleCompra> detalleCompras;

    public Compra() {
    }

    public Compra(Integer idCompra, Date fecha, Double total, Proovedor proovedor, Set<DetalleCompra> detalleCompras) {
        this.idCompra = idCompra;
        this.fecha = fecha;
        this.total = total;
        this.proovedor = proovedor;
        this.detalleCompras = detalleCompras;
    }

    public Integer getIdCompra() {
        return this.idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Date getFecha() {
        return this.fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Double getTotal() {
        return this.total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Proovedor getProovedor() {
        return this.proovedor;
    }

    public void setProovedor(Proovedor proovedor) {
        this.proovedor = proovedor;
    }

    public Set<DetalleCompra> getDetalleCompras() {
        return this.detalleCompras;
    }

    public void setDetalleCompras(Set<DetalleCompra> detalleCompras) {
        this.detalleCompras = detalleCompras;
    }

}
