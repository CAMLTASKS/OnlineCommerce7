/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Tienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface TiendaFacadeLocal {

    void create(Tienda tienda);

    void edit(Tienda tienda);

    void remove(Tienda tienda);

    Tienda find(Object id);

    List<Tienda> findAll();

    List<Tienda> findRange(int[] range);

    int count();
    
}
