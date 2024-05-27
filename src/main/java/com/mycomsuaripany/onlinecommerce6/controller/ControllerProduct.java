/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.controller;

import com.mycomsuaripany.onlinecommerce6.entities.CategoriaProducto;
import com.mycomsuaripany.onlinecommerce6.entities.Producto;
import com.mycomsuaripany.onlinecommerce6.modules.CategoriaProductoFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.ProductoFacadeLocal;
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
@Named(value = "controllerProduct")
@SessionScoped
public class ControllerProduct implements Serializable {

    FacesContext contexto = FacesContext.getCurrentInstance(); 
    FacesMessage fm;
    
    private Producto produ;
    private CategoriaProducto cateProd;
    private List<SelectItem> listaCategoria;
    
    @EJB 
    private ProductoFacadeLocal pfl;
    @EJB
    private CategoriaProductoFacadeLocal cfl;
    
    public ControllerProduct() {
        produ = new Producto();
        cateProd = new CategoriaProducto();
    }

    public Producto getProdu() {
        return produ;
    }

    public void setProdu(Producto produ) {
        this.produ = produ;
    }

    public CategoriaProducto getCateProd() {
        return cateProd;
    }

    public void setCateProd(CategoriaProducto cateProd) {
        this.cateProd = cateProd;
    }
    
    public List<SelectItem> getListaCategoria() {
        listaCategoria = new ArrayList<>();
        try {
            for(CategoriaProducto var: this.cfl.findAll()){
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
    
    public List<Producto> getAll(){
        try {
            return this.pfl.findAll();
        } catch (Exception e) {
        }
        return null;
    }
    
    public void crearProductoP1(){
        contexto = FacesContext.getCurrentInstance();
        this.produ = new Producto();
        try {
            contexto.getExternalContext().redirect("crearProducto.xhtml");
        } catch (Exception e) {
        }
    }
    
    public void crearProducto (){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            produ.setIdCategoriaProducto(cateProd);
            this.pfl.create(produ);
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto Creado correctamente", "MSG_INFO");

        } catch (Exception e) {
            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Error", "MSG_INFO");

        }
        contexto.addMessage(null, fm);

    }
    
    public void actualizarProductoP1(Producto produ){
    contexto = FacesContext.getCurrentInstance();
    this.produ = produ;
        try {
            contexto.getExternalContext().redirect("crearProducto.xhtml");
        } catch (Exception e) {
        }
    
    }
    
    public void actualizarProducto(){
        contexto = FacesContext.getCurrentInstance();
        try {
            this.pfl.edit(produ);
         fm = new FacesMessage (FacesMessage.SEVERITY_INFO,"El producto se ha actualizado", "MSG_INFO");
        } catch (Exception e) {
         fm = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error en la actualizacion", "MSG_ERROR");
        }
        contexto.addMessage(null, fm);
    }

    public void eliminarProducto(Producto produ){
        contexto = FacesContext.getCurrentInstance();
        try {
            this.pfl.remove(produ);
            fm = new FacesMessage (FacesMessage.SEVERITY_INFO,"El registro se ha eliminado", "MSG_INFO");

        } catch (Exception e) {
            fm = new FacesMessage (FacesMessage.SEVERITY_ERROR,"Error en el eliminado", "MSG_ERROR");
        }
        
        contexto.addMessage(null, fm);

    }
   
    
}
