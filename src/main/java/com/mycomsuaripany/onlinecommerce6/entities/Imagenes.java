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
@Table(name = "imagenes")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Imagenes.findAll", query = "SELECT i FROM Imagenes i"),
    @NamedQuery(name = "Imagenes.findByIdImagen", query = "SELECT i FROM Imagenes i WHERE i.idImagen = :idImagen"),
    @NamedQuery(name = "Imagenes.findByNombreArchivo", query = "SELECT i FROM Imagenes i WHERE i.nombreArchivo = :nombreArchivo"),
    @NamedQuery(name = "Imagenes.findByRutaArchivo", query = "SELECT i FROM Imagenes i WHERE i.rutaArchivo = :rutaArchivo"),
    @NamedQuery(name = "Imagenes.findByUrl", query = "SELECT i FROM Imagenes i WHERE i.url = :url"),
    @NamedQuery(name = "Imagenes.findByTitulo", query = "SELECT i FROM Imagenes i WHERE i.titulo = :titulo"),
    @NamedQuery(name = "Imagenes.findByDescripcion", query = "SELECT i FROM Imagenes i WHERE i.descripcion = :descripcion"),
    @NamedQuery(name = "Imagenes.findByFechaCreacion", query = "SELECT i FROM Imagenes i WHERE i.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Imagenes.findByFechaModificacion", query = "SELECT i FROM Imagenes i WHERE i.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Imagenes.findByFormato", query = "SELECT i FROM Imagenes i WHERE i.formato = :formato"),
    @NamedQuery(name = "Imagenes.findBySize", query = "SELECT i FROM Imagenes i WHERE i.size = :size"),
    @NamedQuery(name = "Imagenes.findByEtiquetas", query = "SELECT i FROM Imagenes i WHERE i.etiquetas = :etiquetas")})
public class Imagenes implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_imagen")
    private Integer idImagen;
    @Size(max = 30)
    @Column(name = "nombre_archivo")
    private String nombreArchivo;
    @Size(max = 70)
    @Column(name = "ruta_archivo")
    private String rutaArchivo;
    @Size(max = 100)
    @Column(name = "url")
    private String url;
    @Size(max = 50)
    @Column(name = "titulo")
    private String titulo;
    @Size(max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Size(max = 40)
    @Column(name = "formato")
    private String formato;
    @Column(name = "size")
    private Integer size;
    @Size(max = 100)
    @Column(name = "etiquetas")
    private String etiquetas;
    @JoinColumn(name = "usuario_creacion", referencedColumnName = "id_usuario")
    @ManyToOne(fetch = FetchType.LAZY)
    private Usuario usuarioCreacion;
    @OneToMany(mappedBy = "idImagen", fetch = FetchType.LAZY)
    private List<Producto> productoList;

    public Imagenes() {
    }

    public Imagenes(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public Integer getIdImagen() {
        return idImagen;
    }

    public void setIdImagen(Integer idImagen) {
        this.idImagen = idImagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(String etiquetas) {
        this.etiquetas = etiquetas;
    }

    public Usuario getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(Usuario usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idImagen != null ? idImagen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Imagenes)) {
            return false;
        }
        Imagenes other = (Imagenes) object;
        if ((this.idImagen == null && other.idImagen != null) || (this.idImagen != null && !this.idImagen.equals(other.idImagen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.Imagenes[ idImagen=" + idImagen + " ]";
    }
    
}
