/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.reportes;

import java.math.BigDecimal;

/**
 *
 * @author Torre
 */
public class ReportesVentas {
    private String nombreTienda;
    private BigDecimal total;

    public ReportesVentas(String nombreTienda, BigDecimal total) {
        this.nombreTienda = nombreTienda;
        this.total = total;
    }

    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal sumaPedidos) {
        this.total = sumaPedidos;
    }
    
    
    
    
}
