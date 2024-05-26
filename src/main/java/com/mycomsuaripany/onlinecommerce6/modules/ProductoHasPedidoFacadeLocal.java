/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.ProductoHasPedido;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface ProductoHasPedidoFacadeLocal {

    void create(ProductoHasPedido productoHasPedido);

    void edit(ProductoHasPedido productoHasPedido);

    void remove(ProductoHasPedido productoHasPedido);

    ProductoHasPedido find(Object id);

    List<ProductoHasPedido> findAll();

    List<ProductoHasPedido> findRange(int[] range);

    int count();
    
}
