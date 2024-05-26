/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.entities;

import java.io.Serializable;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "producto_has_venta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasVenta.findAll", query = "SELECT p FROM ProductoHasVenta p"),
    @NamedQuery(name = "ProductoHasVenta.findById", query = "SELECT p FROM ProductoHasVenta p WHERE p.id = :id"),
    @NamedQuery(name = "ProductoHasVenta.findByPrecioUnitario", query = "SELECT p FROM ProductoHasVenta p WHERE p.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "ProductoHasVenta.findByCatidad", query = "SELECT p FROM ProductoHasVenta p WHERE p.catidad = :catidad"),
    @NamedQuery(name = "ProductoHasVenta.findBySubtotal", query = "SELECT p FROM ProductoHasVenta p WHERE p.subtotal = :subtotal"),
    @NamedQuery(name = "ProductoHasVenta.findByDeleted", query = "SELECT p FROM ProductoHasVenta p WHERE p.deleted = :deleted")})
public class ProductoHasVenta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "precio_unitario")
    private Double precioUnitario;
    @Column(name = "catidad")
    private Integer catidad;
    @Column(name = "subtotal")
    private Double subtotal;
    @Column(name = "deleted")
    private Boolean deleted;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "id_venta", referencedColumnName = "id_venta")
    @ManyToOne(fetch = FetchType.LAZY)
    private Ventas idVenta;

    public ProductoHasVenta() {
    }

    public ProductoHasVenta(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCatidad() {
        return catidad;
    }

    public void setCatidad(Integer catidad) {
        this.catidad = catidad;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Ventas getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Ventas idVenta) {
        this.idVenta = idVenta;
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
        if (!(object instanceof ProductoHasVenta)) {
            return false;
        }
        ProductoHasVenta other = (ProductoHasVenta) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.ProductoHasVenta[ id=" + id + " ]";
    }
    
}
