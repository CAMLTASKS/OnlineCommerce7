/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "metodo_pago")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MetodoPago.findAll", query = "SELECT m FROM MetodoPago m"),
    @NamedQuery(name = "MetodoPago.findByIdMetodoPago", query = "SELECT m FROM MetodoPago m WHERE m.idMetodoPago = :idMetodoPago"),
    @NamedQuery(name = "MetodoPago.findByNombre", query = "SELECT m FROM MetodoPago m WHERE m.nombre = :nombre")})
public class MetodoPago implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_metodo_pago")
    private Integer idMetodoPago;
    @Basic(optional = false)
    @NotNull
    @Column(name = "nombre")
    private int nombre;
    @OneToMany(mappedBy = "idMetodoPago", fetch = FetchType.LAZY)
    private List<Pagos> pagosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMetodoPago", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;

    public MetodoPago() {
    }

    public MetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public MetodoPago(Integer idMetodoPago, int nombre) {
        this.idMetodoPago = idMetodoPago;
        this.nombre = nombre;
    }

    public Integer getIdMetodoPago() {
        return idMetodoPago;
    }

    public void setIdMetodoPago(Integer idMetodoPago) {
        this.idMetodoPago = idMetodoPago;
    }

    public int getNombre() {
        return nombre;
    }

    public void setNombre(int nombre) {
        this.nombre = nombre;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMetodoPago != null ? idMetodoPago.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MetodoPago)) {
            return false;
        }
        MetodoPago other = (MetodoPago) object;
        if ((this.idMetodoPago == null && other.idMetodoPago != null) || (this.idMetodoPago != null && !this.idMetodoPago.equals(other.idMetodoPago))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.MetodoPago[ idMetodoPago=" + idMetodoPago + " ]";
    }
    
}
