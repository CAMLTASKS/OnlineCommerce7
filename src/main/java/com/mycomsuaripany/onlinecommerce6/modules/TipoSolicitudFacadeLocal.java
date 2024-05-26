/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.TipoSolicitud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface TipoSolicitudFacadeLocal {

    void create(TipoSolicitud tipoSolicitud);

    void edit(TipoSolicitud tipoSolicitud);

    void remove(TipoSolicitud tipoSolicitud);

    TipoSolicitud find(Object id);

    List<TipoSolicitud> findAll();

    List<TipoSolicitud> findRange(int[] range);

    int count();
    
}
