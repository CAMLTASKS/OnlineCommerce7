/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Carrito;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface CarritoFacadeLocal {

    void create(Carrito carrito);

    void edit(Carrito carrito);

    void remove(Carrito carrito);

    Carrito find(Object id);

    List<Carrito> findAll();

    List<Carrito> findRange(int[] range);

    int count();
    
}
