/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.ProductoHasVenta;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface ProductoHasVentaFacadeLocal {

    void create(ProductoHasVenta productoHasVenta);

    void edit(ProductoHasVenta productoHasVenta);

    void remove(ProductoHasVenta productoHasVenta);

    ProductoHasVenta find(Object id);

    List<ProductoHasVenta> findAll();

    List<ProductoHasVenta> findRange(int[] range);

    int count();
    
}
