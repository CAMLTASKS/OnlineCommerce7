/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "pagos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pagos.findAll", query = "SELECT p FROM Pagos p"),
    @NamedQuery(name = "Pagos.findByIdPagos", query = "SELECT p FROM Pagos p WHERE p.idPagos = :idPagos"),
    @NamedQuery(name = "Pagos.findByFechaPago", query = "SELECT p FROM Pagos p WHERE p.fechaPago = :fechaPago"),
    @NamedQuery(name = "Pagos.findByMontoPago", query = "SELECT p FROM Pagos p WHERE p.montoPago = :montoPago"),
    @NamedQuery(name = "Pagos.findByMoneda", query = "SELECT p FROM Pagos p WHERE p.moneda = :moneda"),
    @NamedQuery(name = "Pagos.findByEstadoPago", query = "SELECT p FROM Pagos p WHERE p.estadoPago = :estadoPago"),
    @NamedQuery(name = "Pagos.findByDetallePago", query = "SELECT p FROM Pagos p WHERE p.detallePago = :detallePago")})
public class Pagos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_pagos")
    private Integer idPagos;
    @Column(name = "fecha_pago")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Column(name = "monto_pago")
    private Integer montoPago;
    @Size(max = 50)
    @Column(name = "moneda")
    private String moneda;
    @Column(name = "estado_pago")
    private Boolean estadoPago;
    @Size(max = 50)
    @Column(name = "detalle_pago")
    private String detallePago;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido idPedido;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @JoinColumn(name = "id_metodo_pago", referencedColumnName = "id_metodo_pago")
    @ManyToOne(fetch = FetchType.LAZY)
    private MetodoPago idMetodoPago;
    @OneToMany(mappedBy = "idPago", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;

    public Pagos() {
    }

    public Pagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Integer getIdPagos() {
        return idPagos;
    }

    public void setIdPagos(Integer idPagos) {
        this.idPagos = idPagos;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public Integer getMontoPago() {
        return montoPago;
    }

    public void setMontoPago(Integer montoPago) {
        this.montoPago = montoPago;
    }

    public String getMoneda() {
        return moneda;
    }

    public void setMoneda(String moneda) {
        this.moneda = moneda;
    }

    public Boolean getEstadoPago() {
        return estadoPago;
    }

    public void setEstadoPago(Boolean estadoPago) {
        this.estadoPago = estadoPago;
    }

    public String getDetallePago() {
        return detallePago;
    }

    public void setDetallePago(String detallePago) {
        this.detallePago = detallePago;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    public MetodoPago getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(MetodoPago idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagos != null ? idPagos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pagos)) {
            return false;
        }
        Pagos other = (Pagos) object;
        if ((this.idPagos == null && other.idPagos != null) || (this.idPagos != null && !this.idPagos.equals(other.idPagos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.Pagos[ idPagos=" + idPagos + " ]";
    }
    
}
