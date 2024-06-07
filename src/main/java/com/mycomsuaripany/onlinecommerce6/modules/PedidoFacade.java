package com.mycomsuaripany.onlinecommerce6.modules;

import com.mycomsuaripany.onlinecommerce6.entities.Pedido;
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
public class PedidoFacade extends AbstractFacade<Pedido> implements PedidoFacadeLocal {

    @PersistenceContext(unitName = "com.mycomsuaripany_OnlineCommerce6_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PedidoFacade() {
        super(Pedido.class);
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
            e.printStackTrace();
            System.out.println("Error" + e.getMessage());
        }
        
        return null;
    }
    
}

