/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.UsuarioHasRol;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Torre
 */
@Local
public interface UsuarioHasRolFacadeLocal {

    void create(UsuarioHasRol usuarioHasRol);

    void edit(UsuarioHasRol usuarioHasRol);

    void remove(UsuarioHasRol usuarioHasRol);

    UsuarioHasRol find(Object id);

    List<UsuarioHasRol> findAll();

    List<UsuarioHasRol> findRange(int[] range);

    int count();
    
}
