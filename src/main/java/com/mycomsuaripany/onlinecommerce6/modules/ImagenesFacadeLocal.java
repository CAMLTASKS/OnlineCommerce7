/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Imagenes;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface ImagenesFacadeLocal {

    void create(Imagenes imagenes);

    void edit(Imagenes imagenes);

    void remove(Imagenes imagenes);

    Imagenes find(Object id);

    List<Imagenes> findAll();

    List<Imagenes> findRange(int[] range);

    int count();
    
}
