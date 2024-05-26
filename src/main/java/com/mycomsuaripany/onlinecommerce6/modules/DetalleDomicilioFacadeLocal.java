/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.DetalleDomicilio;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface DetalleDomicilioFacadeLocal {

    void create(DetalleDomicilio detalleDomicilio);

    void edit(DetalleDomicilio detalleDomicilio);

    void remove(DetalleDomicilio detalleDomicilio);

    DetalleDomicilio find(Object id);

    List<DetalleDomicilio> findAll();

    List<DetalleDomicilio> findRange(int[] range);

    int count();
    
}
