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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "detalle_fisico")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DetalleFisico.findAll", query = "SELECT d FROM DetalleFisico d"),
    @NamedQuery(name = "DetalleFisico.findByIdFisico", query = "SELECT d FROM DetalleFisico d WHERE d.idFisico = :idFisico"),
    @NamedQuery(name = "DetalleFisico.findByFechaRecogerInicio", query = "SELECT d FROM DetalleFisico d WHERE d.fechaRecogerInicio = :fechaRecogerInicio"),
    @NamedQuery(name = "DetalleFisico.findByFechaRecogerFin", query = "SELECT d FROM DetalleFisico d WHERE d.fechaRecogerFin = :fechaRecogerFin"),
    @NamedQuery(name = "DetalleFisico.findByDeleted", query = "SELECT d FROM DetalleFisico d WHERE d.deleted = :deleted")})
public class DetalleFisico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_fisico")
    private Integer idFisico;
    @Column(name = "fecha_recoger_inicio")
    @Temporal(TemporalType.DATE)
    private Date fechaRecogerInicio;
    @Column(name = "fecha_recoger_fin")
    @Temporal(TemporalType.DATE)
    private Date fechaRecogerFin;
    @Column(name = "deleted")
    private Boolean deleted;
    @JoinColumn(name = "id_pedido", referencedColumnName = "id_pedido")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Pedido idPedido;

    public DetalleFisico() {
    }

    public DetalleFisico(Integer idFisico) {
        this.idFisico = idFisico;
    }

    public Integer getIdFisico() {
        return idFisico;
    }

    public void setIdFisico(Integer idFisico) {
        this.idFisico = idFisico;
    }

    public Date getFechaRecogerInicio() {
        return fechaRecogerInicio;
    }

    public void setFechaRecogerInicio(Date fechaRecogerInicio) {
        this.fechaRecogerInicio = fechaRecogerInicio;
    }

    public Date getFechaRecogerFin() {
        return fechaRecogerFin;
    }

    public void setFechaRecogerFin(Date fechaRecogerFin) {
        this.fechaRecogerFin = fechaRecogerFin;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFisico != null ? idFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFisico)) {
            return false;
        }
        DetalleFisico other = (DetalleFisico) object;
        if ((this.idFisico == null && other.idFisico != null) || (this.idFisico != null && !this.idFisico.equals(other.idFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.DetalleFisico[ idFisico=" + idFisico + " ]";
    }
    
}
