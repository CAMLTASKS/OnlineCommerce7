/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.InteraccionSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface InteraccionSolicitudFacadeLocal {

    void create(InteraccionSolicitud interaccionSolicitud);

    void edit(InteraccionSolicitud interaccionSolicitud);

    void remove(InteraccionSolicitud interaccionSolicitud);

    InteraccionSolicitud find(Object id);

    List<InteraccionSolicitud> findAll();

    List<InteraccionSolicitud> findRange(int[] range);

    int count();
    
}
