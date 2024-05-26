/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.DetalleFisico;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface DetalleFisicoFacadeLocal {

    void create(DetalleFisico detalleFisico);

    void edit(DetalleFisico detalleFisico);

    void remove(DetalleFisico detalleFisico);

    DetalleFisico find(Object id);

    List<DetalleFisico> findAll();

    List<DetalleFisico> findRange(int[] range);

    int count();
    
}
