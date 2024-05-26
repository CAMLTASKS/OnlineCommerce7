/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.CategoriaProducto;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface CategoriaProductoFacadeLocal {

    void create(CategoriaProducto categoriaProducto);

    void edit(CategoriaProducto categoriaProducto);

    void remove(CategoriaProducto categoriaProducto);

    CategoriaProducto find(Object id);

    List<CategoriaProducto> findAll();

    List<CategoriaProducto> findRange(int[] range);

    int count();
    
}
