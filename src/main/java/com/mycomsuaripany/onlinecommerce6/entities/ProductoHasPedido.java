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
@Table(name = "producto_has_pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ProductoHasPedido.findAll", query = "SELECT p FROM ProductoHasPedido p"),
    @NamedQuery(name = "ProductoHasPedido.findById", query = "SELECT p FROM ProductoHasPedido p WHERE p.id = :id"),
    @NamedQuery(name = "ProductoHasPedido.findByDeleted", query = "SELECT p FROM ProductoHasPedido p WHERE p.deleted = :deleted"),
    @NamedQuery(name = "ProductoHasPedido.findByPrecioUnitario", query = "SELECT p FROM ProductoHasPedido p WHERE p.precioUnitario = :precioUnitario"),
    @NamedQuery(name = "ProductoHasPedido.findByCantidad", query = "SELECT p FROM ProductoHasPedido p WHERE p.cantidad = :cantidad"),
    @NamedQuery(name = "ProductoHasPedido.findBySubtotal", query = "SELECT p FROM ProductoHasPedido p WHERE p.subtotal = :subtotal")})
public class ProductoHasPedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "precio_unitario")
    private Integer precioUnitario;
    @Column(name = "cantidad")
    private Integer cantidad;
    @Column(name = "subtotal")
    private Integer subtotal;
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne(fetch = FetchType.LAZY)
    private Producto idProducto;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(fetch = FetchType.LAZY)
    private Pedido idPedido;

    public ProductoHasPedido() {
    }

    public ProductoHasPedido(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }

    public Pedido getIdPedido() {
        return idPedido;
    }

    public void setIdPedido(Pedido idPedido) {
        this.idPedido = idPedido;
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
        if (!(object instanceof ProductoHasPedido)) {
            return false;
        }
        ProductoHasPedido other = (ProductoHasPedido) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.ProductoHasPedido[ id=" + id + " ]";
    }
    
}
