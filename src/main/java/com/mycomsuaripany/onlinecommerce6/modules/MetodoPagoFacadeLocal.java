/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.MetodoPago;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface MetodoPagoFacadeLocal {

    void create(MetodoPago metodoPago);

    void edit(MetodoPago metodoPago);

    void remove(MetodoPago metodoPago);

    MetodoPago find(Object id);

    List<MetodoPago> findAll();

    List<MetodoPago> findRange(int[] range);

    int count();
    
}
