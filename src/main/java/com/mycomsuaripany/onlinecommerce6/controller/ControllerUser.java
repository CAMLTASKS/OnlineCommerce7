/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.controller;

import com.mycomsuaripany.onlinecommerce6.entities.Rol;
import com.mycomsuaripany.onlinecommerce6.entities.Usuario;
import com.mycomsuaripany.onlinecommerce6.entities.UsuarioHasRol;
import com.mycomsuaripany.onlinecommerce6.modules.UsuarioFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.UsuarioHasRolFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Torre
 */
@Named(value = "controllerUser")
@SessionScoped
public class ControllerUser implements Serializable {

    FacesContext contexto = FacesContext.getCurrentInstance(); 
    FacesMessage fm;

    private Rol rol;
    private Usuario usuario;
    private UsuarioHasRol usuarioHasRol;
    private List<UsuarioHasRol> usuarioHasRolList;
    
    
    @EJB
    private UsuarioFacadeLocal ufl;
    
    
    
    public ControllerUser() {
        usuario = new Usuario();
        usuarioHasRol = new UsuarioHasRol();
        rol = new Rol();
        usuarioHasRolList = new ArrayList<>();

    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public UsuarioHasRol getUsuarioHasRol() {
        return usuarioHasRol;
    }

    public void setUsuarioHasRol(UsuarioHasRol usuarioHasRol) {
        this.usuarioHasRol = usuarioHasRol;
    } 

    public List<UsuarioHasRol> getUsuarioHasRolList() {
        return usuarioHasRolList;
    }

    public void setUsuarioHasRolList(List<UsuarioHasRol> usuarioHasRolList) {
        this.usuarioHasRolList = usuarioHasRolList;
    }
    
    //Creamos el usuario y le setteamos el una lista usuarioHasRol con el rol comprador por defecto
    public void crearUsuario(){
        FacesContext contexto = FacesContext.getCurrentInstance();
        try {
            rol.setIdRol(2); //le setteamos el rol 2 quien es el compradpr
            usuarioHasRol.setIdRol(rol); // Asignamos el rol al usuario
            usuarioHasRol.setIdUsuario(usuario); // Asignamos el usuario
            usuarioHasRolList.add(usuarioHasRol); // Agregamos el usuarioHasRol a la lista de roles del usuario
            usuario.setUsuarioHasRolList(usuarioHasRolList); // Actualizamos la lista de roles del usuario
            
            this.ufl.create(usuario); //  Creamos el usuario en la base de datos 

            fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Usuario Creado correctamente", "MSG_INFO");
            System.out.println("Creado correctamente");
            
        } catch (Exception e) {
            fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error al crear el usuario", "MSG_ERROR");
            System.out.println("Error de creacion");
        }
        contexto.addMessage(null, fm);
    }
    
    public void iniciarSesion(){
        contexto = FacesContext.getCurrentInstance();
        try {
            this.usuario = this.ufl.iniciarSesion(usuario);
            if (this.usuario!=null){
            contexto.getExternalContext().redirect("index.xhtml");
            }else {
                fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Usiario y/o contraseña invalidos", "MSG_ERROR");
                contexto.addMessage(null, fm);
            }
        } catch (Exception e) {
        }
        
        this.usuario = new Usuario();
    }
    
    
}
