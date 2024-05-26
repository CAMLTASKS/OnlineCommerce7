/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "detalle_domicilio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleDomicilio.findAll", query = "SELECT d FROM DetalleDomicilio d"),
    @NamedQuery(name = "DetalleDomicilio.findById", query = "SELECT d FROM DetalleDomicilio d WHERE d.id = :id"),
    @NamedQuery(name = "DetalleDomicilio.findByFechaHoraPedidoListo", query = "SELECT d FROM DetalleDomicilio d WHERE d.fechaHoraPedidoListo = :fechaHoraPedidoListo"),
    @NamedQuery(name = "DetalleDomicilio.findByFechaHoraPedidoRecogido", query = "SELECT d FROM DetalleDomicilio d WHERE d.fechaHoraPedidoRecogido = :fechaHoraPedidoRecogido"),
    @NamedQuery(name = "DetalleDomicilio.findByFechaHoraPedidoEntrega", query = "SELECT d FROM DetalleDomicilio d WHERE d.fechaHoraPedidoEntrega = :fechaHoraPedidoEntrega"),
    @NamedQuery(name = "DetalleDomicilio.findByEstado", query = "SELECT d FROM DetalleDomicilio d WHERE d.estado = :estado"),
    @NamedQuery(name = "DetalleDomicilio.findByNovedades", query = "SELECT d FROM DetalleDomicilio d WHERE d.novedades = :novedades"),
    @NamedQuery(name = "DetalleDomicilio.findByDeleted", query = "SELECT d FROM DetalleDomicilio d WHERE d.deleted = :deleted")})
public class DetalleDomicilio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_pedido_listo")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPedidoListo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_pedido_recogido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPedidoRecogido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_hora_pedido_entrega")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraPedidoEntrega;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado")
    private String estado;
    @Size(max = 250)
    @Column(name = "novedades")
    private String novedades;
    @Column(name = "deleted")
    private Boolean deleted;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido idPedido;
    @JoinColumn(name = "id_direccion", referencedColumnName = "id_direccion")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Direccion idDireccion;
    @JoinColumn(name = "id_usuario_domiciliario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuarioDomiciliario;

    public DetalleDomicilio() {
    }

    public DetalleDomicilio(Integer id) {
        this.id = id;
    }

    public DetalleDomicilio(Integer id, Date fechaHoraPedidoListo, Date fechaHoraPedidoRecogido, Date fechaHoraPedidoEntrega, String estado) {
        this.id = id;
        this.fechaHoraPedidoListo = fechaHoraPedidoListo;
        this.fechaHoraPedidoRecogido = fechaHoraPedidoRecogido;
        this.fechaHoraPedidoEntrega = fechaHoraPedidoEntrega;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaHoraPedidoListo() {
        return fechaHoraPedidoListo;
    }

    public void setFechaHoraPedidoListo(Date fechaHoraPedidoListo) {
        this.fechaHoraPedidoListo = fechaHoraPedidoListo;
    }

    public Date getFechaHoraPedidoRecogido() {
        return fechaHoraPedidoRecogido;
    }

    public void setFechaHoraPedidoRecogido(Date fechaHoraPedidoRecogido) {
        this.fechaHoraPedidoRecogido = fechaHoraPedidoRecogido;
    }

    public Date getFechaHoraPedidoEntrega() {
        return fechaHoraPedidoEntrega;
    }

    public void setFechaHoraPedidoEntrega(Date fechaHoraPedidoEntrega) {
        this.fechaHoraPedidoEntrega = fechaHoraPedidoEntrega;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getNovedades() {
        return novedades;
    }

    public void setNovedades(String novedades) {
        this.novedades = novedades;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
    }

    public Direccion getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(Direccion idDireccion) {
        this.idDireccion = idDireccion;
    }

    public Usuario getIdUsuarioDomiciliario() {
        return idUsuarioDomiciliario;
    }

    public void setIdUsuarioDomiciliario(Usuario idUsuarioDomiciliario) {
        this.idUsuarioDomiciliario = idUsuarioDomiciliario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleDomicilio)) {
            return false;
        }
        DetalleDomicilio other = (DetalleDomicilio) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.DetalleDomicilio[ id=" + id + " ]";
    }
    
}
