/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.controller;

import com.mycomsuaripany.onlinecommerce6.entities.CategoriaTienda;
import com.mycomsuaripany.onlinecommerce6.entities.Direccion;
import com.mycomsuaripany.onlinecommerce6.entities.Inventario;
import com.mycomsuaripany.onlinecommerce6.entities.Tienda;
import com.mycomsuaripany.onlinecommerce6.entities.Usuario;
import com.mycomsuaripany.onlinecommerce6.modules.CategoriaTiendaFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.DireccionFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.TiendaFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

/**
 *
 * @author Torre
 */
@Named(value = "controllerTienda")
@SessionScoped
public class ControllerTienda implements Serializable {

    FacesContext contexto = FacesContext.getCurrentInstance(); 
    FacesMessage fm;
    
    private Tienda tienda;
    private Usuario usuario;
    private CategoriaTienda categoriaTienda;
    private List<SelectItem> listaCategoria;
    private Inventario inventario;
    private List<Inventario> listaInventario;
    private Direccion direccion;
    
    @EJB
    private TiendaFacadeLocal tfl;
//    @EJB 
//    private UsuarioFacadeLocal ufl;
    @EJB
    private CategoriaTiendaFacadeLocal cfl;
//    @EJB 
//    private DireccionFacadeLocal dfl;
    
    
    public ControllerTienda() {
        tienda = new Tienda();
        categoriaTienda = new CategoriaTienda();
        
    }

    
    

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public CategoriaTienda getCategoriaTienda() {
        return categoriaTienda;
    }

    public void setCategoriaTienda(CategoriaTienda categoriaTienda) {
        this.categoriaTienda = categoriaTienda;
    }

    public List<SelectItem> getListaCategoria() {
        listaCategoria = new ArrayList<>();
        try {
            for(CategoriaTienda var: this.cfl.findAll()){
                SelectItem item = new SelectItem(var.getIdCategoria(), var.getNombre());
                listaCategoria.add(item);
            }
        } catch (Exception e) {
        }
        return listaCategoria;
    }

    public void setListaCategoria(List<SelectItem> listaCategoria) {
        this.listaCategoria = listaCategoria;
    }

    public Inventario getInventario() {
        return inventario;
    }

    public void setInventario(Inventario inventario) {
        this.inventario = inventario;
    }

    public List<Inventario> getListaInventario() {
        return listaInventario;
    }

    public void setListaInventario(List<Inventario> listaInventario) {
        this.listaInventario = listaInventario;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }
    
    public List<Tienda> getAll(){
        try {
            return this.tfl.findAll();
        } catch (Exception e) {
        }
        return null;
    }
    
    public void crearTiendaP1(){
        contexto = FacesContext.getCurrentInstance();
        this.tienda = new Tienda();
        try {
            contexto.getExternalContext().redirect("crearTienda.xhtml");
        } catch (Exception e) {
        }
    }
    
    public void crearTienda(){
    FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            tienda.setIdCategoria(categoriaTienda);
            this.tfl.create(tienda);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Tienda Creada correctamente", "MSG_INFO");
        } catch (Exception e) {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear la tienda", "MSG_ERROR");
        }       
        contexto.addMessage(null, fm);

    }
    
    public void actualizarTiendaP1(Tienda tienda){
        contexto = FacesContext.getCurrentInstance();
        this.tienda = tienda;
        try {
            contexto.getExternalContext().redirect("crearTienda.xhtml");
        } catch (Exception e) {
        }
    }
    
    public void actualizarTienda(){
    contexto = FacesContext.getCurrentInstance();
            try { 
            this.tfl.edit(tienda);
            fm = new FacesMessage (FacesMessage.SEVERITY_INFO,"El registro se ha Actualizado", "MSG_INFO");
        } catch (Exception e) {
            fm = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error en la Actualizacioj", "MSG_ERROR");
        }
    contexto.addMessage(null, fm);
    }
     
    public void eliminarTienda(Tienda tienda){
    contexto = FacesContext.getCurrentInstance();
            try { 
            contexto = FacesContext.getCurrentInstance();
            this.tienda = tienda;
            
            this.tfl.remove(tienda);
            fm = new FacesMessage (FacesMessage.SEVERITY_INFO,"El registro se ha Eliminado", "MSG_INFO");
        } catch (Exception e) {
            fm = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error en el Eliminado", "MSG_ERROR");
        }
    contexto.addMessage(null, fm);
    } 
    
    
    
      
}
