/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.entities;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Torre
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u"),
    @NamedQuery(name = "Usuario.findByIdUsuario", query = "SELECT u FROM Usuario u WHERE u.idUsuario = :idUsuario"),
    @NamedQuery(name = "Usuario.findByNombre", query = "SELECT u FROM Usuario u WHERE u.nombre = :nombre"),
    @NamedQuery(name = "Usuario.findByApellido", query = "SELECT u FROM Usuario u WHERE u.apellido = :apellido"),
    @NamedQuery(name = "Usuario.findByCorreo", query = "SELECT u FROM Usuario u WHERE u.correo = :correo"),
    @NamedQuery(name = "Usuario.findByContrasena", query = "SELECT u FROM Usuario u WHERE u.contrasena = :contrasena"),
    @NamedQuery(name = "Usuario.findByEstado", query = "SELECT u FROM Usuario u WHERE u.estado = :estado"),
    @NamedQuery(name = "Usuario.findByDeleted", query = "SELECT u FROM Usuario u WHERE u.deleted = :deleted"),
    @NamedQuery(name = "Usuario.findByFechaCreacion", query = "SELECT u FROM Usuario u WHERE u.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "Usuario.findByFechaModificacion", query = "SELECT u FROM Usuario u WHERE u.fechaModificacion = :fechaModificacion"),
    @NamedQuery(name = "Usuario.findByTelefono", query = "SELECT u FROM Usuario u WHERE u.telefono = :telefono"),
    @NamedQuery(name = "Usuario.findByFechaNacimiento", query = "SELECT u FROM Usuario u WHERE u.fechaNacimiento = :fechaNacimiento"),
    @NamedQuery(name = "Usuario.findByCedula", query = "SELECT u FROM Usuario u WHERE u.cedula = :cedula"),
    @NamedQuery(name = "Usuario.findByTipoCedula", query = "SELECT u FROM Usuario u WHERE u.tipoCedula = :tipoCedula"),
    @NamedQuery(name = "Usuario.findByGenero", query = "SELECT u FROM Usuario u WHERE u.genero = :genero")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "apellido")
    private String apellido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "correo")
    private String correo;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "contrasena")
    private String contrasena;
    @Column(name = "estado")
    private Boolean estado;
    @Column(name = "deleted")
    private Boolean deleted;
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Column(name = "telefono")
    private Integer telefono;
    @Column(name = "fecha_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    @Column(name = "cedula")
    private Integer cedula;
    @Size(max = 30)
    @Column(name = "tipo_cedula")
    private String tipoCedula;
    @Size(max = 50)
    @Column(name = "genero")
    private String genero;
    @OneToMany(mappedBy = "usuarioCreacion", fetch = FetchType.LAZY)
    private List<Imagenes> imagenesList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<UsuarioHasRol> usuarioHasRolList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion", fetch = FetchType.LAZY)
    private List<InteraccionSolicitud> interaccionSolicitudList;
    @OneToMany(mappedBy = "idUsuarioModified", fetch = FetchType.LAZY)
    private List<Producto> productoList;
    @OneToMany(mappedBy = "idUsuarioCreacion", fetch = FetchType.LAZY)
    private List<Producto> productoList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Carrito> carritoList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Pagos> pagosList;
    @OneToMany(mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Tienda> tiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList;
    @OneToMany(mappedBy = "idUsuarioRespuesta", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList1;
    @OneToMany(mappedBy = "idUsuarioModificacion", fetch = FetchType.LAZY)
    private List<Solicitud> solicitudList2;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuario", fetch = FetchType.LAZY)
    private List<Pedido> pedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion", fetch = FetchType.LAZY)
    private List<Ventas> ventasList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioDomiciliario", fetch = FetchType.LAZY)
    private List<DetalleDomicilio> detalleDomicilioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUsuarioCreacion", fetch = FetchType.LAZY)
    private List<Inventario> inventarioList;
    @OneToMany(mappedBy = "idUsuarioModificacion", fetch = FetchType.LAZY)
    private List<Inventario> inventarioList1;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String nombre, String apellido, String correo, String contrasena) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Boolean getDeleted() {
        return deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public Integer getTelefono() {
        return telefono;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getTipoCedula() {
        return tipoCedula;
    }

    public void setTipoCedula(String tipoCedula) {
        this.tipoCedula = tipoCedula;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    @XmlTransient
    public List<Imagenes> getImagenesList() {
        return imagenesList;
    }

    public void setImagenesList(List<Imagenes> imagenesList) {
        this.imagenesList = imagenesList;
    }

    @XmlTransient
    public List<UsuarioHasRol> getUsuarioHasRolList() {
        return usuarioHasRolList;
    }

    public void setUsuarioHasRolList(List<UsuarioHasRol> usuarioHasRolList) {
        this.usuarioHasRolList = usuarioHasRolList;
    }

    @XmlTransient
    public List<InteraccionSolicitud> getInteraccionSolicitudList() {
        return interaccionSolicitudList;
    }

    public void setInteraccionSolicitudList(List<InteraccionSolicitud> interaccionSolicitudList) {
        this.interaccionSolicitudList = interaccionSolicitudList;
    }

    @XmlTransient
    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @XmlTransient
    public List<Producto> getProductoList1() {
        return productoList1;
    }

    public void setProductoList1(List<Producto> productoList1) {
        this.productoList1 = productoList1;
    }

    @XmlTransient
    public List<Carrito> getCarritoList() {
        return carritoList;
    }

    public void setCarritoList(List<Carrito> carritoList) {
        this.carritoList = carritoList;
    }

    @XmlTransient
    public List<Pagos> getPagosList() {
        return pagosList;
    }

    public void setPagosList(List<Pagos> pagosList) {
        this.pagosList = pagosList;
    }

    @XmlTransient
    public List<Tienda> getTiendaList() {
        return tiendaList;
    }

    public void setTiendaList(List<Tienda> tiendaList) {
        this.tiendaList = tiendaList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList() {
        return solicitudList;
    }

    public void setSolicitudList(List<Solicitud> solicitudList) {
        this.solicitudList = solicitudList;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList1() {
        return solicitudList1;
    }

    public void setSolicitudList1(List<Solicitud> solicitudList1) {
        this.solicitudList1 = solicitudList1;
    }

    @XmlTransient
    public List<Solicitud> getSolicitudList2() {
        return solicitudList2;
    }

    public void setSolicitudList2(List<Solicitud> solicitudList2) {
        this.solicitudList2 = solicitudList2;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<Ventas> getVentasList() {
        return ventasList;
    }

    public void setVentasList(List<Ventas> ventasList) {
        this.ventasList = ventasList;
    }

    @XmlTransient
    public List<DetalleDomicilio> getDetalleDomicilioList() {
        return detalleDomicilioList;
    }

    public void setDetalleDomicilioList(List<DetalleDomicilio> detalleDomicilioList) {
        this.detalleDomicilioList = detalleDomicilioList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList() {
        return inventarioList;
    }

    public void setInventarioList(List<Inventario> inventarioList) {
        this.inventarioList = inventarioList;
    }

    @XmlTransient
    public List<Inventario> getInventarioList1() {
        return inventarioList1;
    }

    public void setInventarioList1(List<Inventario> inventarioList1) {
        this.inventarioList1 = inventarioList1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycomsuaripany.onlinecommerce6.entities.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
