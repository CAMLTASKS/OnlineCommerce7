/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Pagos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface PagosFacadeLocal {

    void create(Pagos pagos);

    void edit(Pagos pagos);

    void remove(Pagos pagos);

    Pagos find(Object id);

    List<Pagos> findAll();

    List<Pagos> findRange(int[] range);

    int count();
    
}
