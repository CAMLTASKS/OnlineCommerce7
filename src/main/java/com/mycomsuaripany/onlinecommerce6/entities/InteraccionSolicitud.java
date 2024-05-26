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
@Table(name = "interaccion_solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InteraccionSolicitud.findAll", query = "SELECT i FROM InteraccionSolicitud i"),
    @NamedQuery(name = "InteraccionSolicitud.findByIdInteraccion", query = "SELECT i FROM InteraccionSolicitud i WHERE i.idInteraccion = :idInteraccion"),
    @NamedQuery(name = "InteraccionSolicitud.findByDeleted", query = "SELECT i FROM InteraccionSolicitud i WHERE i.deleted = :deleted"),
    @NamedQuery(name = "InteraccionSolicitud.findByInteraccion", query = "SELECT i FROM InteraccionSolicitud i WHERE i.interaccion = :interaccion"),
    @NamedQuery(name = "InteraccionSolicitud.findByEstado", query = "SELECT i FROM InteraccionSolicitud i WHERE i.estado = :estado"),
    @NamedQuery(name = "InteraccionSolicitud.findByFechaCreacion", query = "SELECT i FROM InteraccionSolicitud i WHERE i.fechaCreacion = :fechaCreacion")})
public class InteraccionSolicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_interaccion")
    private Integer idInteraccion;
    @Column(name = "deleted")
    private Boolean deleted;
    @Size(max = 300)
    @Column(name = "interaccion")
    private String interaccion;
    @Size(max = 50)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @JoinColumn(name = "id_usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuarioCreacion;

    public InteraccionSolicitud() {
    }

    public InteraccionSolicitud(Integer idInteraccion) {
        this.idInteraccion = idInteraccion;
    }

    public InteraccionSolicitud(Integer idInteraccion, Date fechaCreacion) {
        this.idInteraccion = idInteraccion;
        this.fechaCreacion = fechaCreacion;
    }

    public Integer getIdInteraccion() {
        return idInteraccion;
    }

    public void setIdInteraccion(Integer idInteraccion) {
        this.idInteraccion = idInteraccion;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    public String getInteraccion() {
        return interaccion;
    }

    public void setInteraccion(String interaccion) {
        this.interaccion = interaccion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Usuario getIdUsuarioCreacion() {
        return idUsuarioCreacion;
    }

    public void setIdUsuarioCreacion(Usuario idUsuarioCreacion) {
        this.idUsuarioCreacion = idUsuarioCreacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInteraccion != null ? idInteraccion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InteraccionSolicitud)) {
            return false;
        }
        InteraccionSolicitud other = (InteraccionSolicitud) object;
        if ((this.idInteraccion == null && other.idInteraccion != null) || (this.idInteraccion != null && !this.idInteraccion.equals(other.idInteraccion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.InteraccionSolicitud[ idInteraccion=" + idInteraccion + " ]";
    }
    
}
