/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Ventas;
import com.mycomsuaripany.onlinecommerce6.reportes.ReportesVentas;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Torre
 */
@Stateless
public class VentasFacade extends AbstractFacade<Ventas> implements VentasFacadeLocal {

    @PersistenceContext(unitName = "com.mycomsuaripany_OnlineCommerce6_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VentasFacade() {
        super(Ventas.class);
    }
    
    @Override
    public List<ReportesVentas> datosGrafico() {
        Query query;
        List<ReportesVentas> lista;
        try {
            query = em.createQuery("SELECT NEW com.mycomsuaripany.onlinecommerce6.reportes.ReportesPedido(T.nombre, SUM(V.total)) FROM Tienda T INNER JOIN T.ventasList V GROUP BY T.nombre", ReportesVentas.class);
            lista = query.getResultList();
            return lista;
        } catch (Exception e) {
            System.out.println("Error" + e.getMessage());
        }
        
        return null;
    }
}
