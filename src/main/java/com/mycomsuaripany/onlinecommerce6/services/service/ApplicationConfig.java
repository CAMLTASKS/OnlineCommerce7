/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.services.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author Torre
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.CarritoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.CategoriaProductoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.CategoriaTiendaFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.DetalleDomicilioFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.DetalleFisicoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.DireccionFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.ImagenesFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.InteraccionSolicitudFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.InventarioFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.MetodoPagoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.PagosFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.PedidoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.ProductoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.ProductoHasPedidoFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.ProductoHasVentaFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.RolFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.SolicitudFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.TiendaFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.TipoSolicitudFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.UsuarioFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.UsuarioHasRolFacadeREST.class);
        resources.add(com.mycomsuaripany.onlinecommerce6.services.service.VentasFacadeREST.class);
    }
    
}
