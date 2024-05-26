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
@Table(name = "carrito")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Carrito.findAll", query = "SELECT c FROM Carrito c"),
    @NamedQuery(name = "Carrito.findByIdCarrito", query = "SELECT c FROM Carrito c WHERE c.idCarrito = :idCarrito"),
    @NamedQuery(name = "Carrito.findByFechaCreaci\u00f3n", query = "SELECT c FROM Carrito c WHERE c.fechaCreaci\u00f3n = :fechaCreaci\u00f3n"),
    @NamedQuery(name = "Carrito.findByDeleted", query = "SELECT c FROM Carrito c WHERE c.deleted = :deleted"),
    @NamedQuery(name = "Carrito.findByEstadoCarrito", query = "SELECT c FROM Carrito c WHERE c.estadoCarrito = :estadoCarrito")})
public class Carrito implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_carrito")
    private Integer idCarrito;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creaci\u00f3n")
    @Temporal(TemporalType.DATE)
    private Date fechaCreación;
    @Basic(optional = false)
    @NotNull
    @Column(name = "deleted")
    private int deleted;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "estado_carrito")
    private String estadoCarrito;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Carrito() {
    }

    public Carrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Carrito(Integer idCarrito, Date fechaCreación, int deleted, String estadoCarrito) {
        this.idCarrito = idCarrito;
        this.fechaCreación = fechaCreación;
        this.deleted = deleted;
        this.estadoCarrito = estadoCarrito;
    }

    public Integer getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(Integer idCarrito) {
        this.idCarrito = idCarrito;
    }

    public Date getFechaCreación() {
        return fechaCreación;
    }

    public void setFechaCreación(Date fechaCreación) {
        this.fechaCreación = fechaCreación;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public String getEstadoCarrito() {
        return estadoCarrito;
    }

    public void setEstadoCarrito(String estadoCarrito) {
        this.estadoCarrito = estadoCarrito;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCarrito != null ? idCarrito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Carrito)) {
            return false;
        }
        Carrito other = (Carrito) object;
        if ((this.idCarrito == null && other.idCarrito != null) || (this.idCarrito != null && !this.idCarrito.equals(other.idCarrito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.Carrito[ idCarrito=" + idCarrito + " ]";
    }
    
}
