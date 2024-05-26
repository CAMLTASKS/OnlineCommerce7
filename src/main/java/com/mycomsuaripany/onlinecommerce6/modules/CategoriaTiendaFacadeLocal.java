/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.CategoriaTienda;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface CategoriaTiendaFacadeLocal {

    void create(CategoriaTienda categoriaTienda);

    void edit(CategoriaTienda categoriaTienda);

    void remove(CategoriaTienda categoriaTienda);

    CategoriaTienda find(Object id);

    List<CategoriaTienda> findAll();

    List<CategoriaTienda> findRange(int[] range);

    int count();
    
}
