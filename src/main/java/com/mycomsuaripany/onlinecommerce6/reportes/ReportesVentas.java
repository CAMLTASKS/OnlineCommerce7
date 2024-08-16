package com.mycomsuaripany.onlinecommerce6.reportes;

import java.math.BigDecimal;

public class ReportesVentas {

    private String nombreTienda;
    private BigDecimal total;

    public ReportesVentas(String nombreTienda, BigDecimal total) {
        this.nombreTienda = nombreTienda;
        this.total = total;
    }

    // Getters y setters
    public String getNombreTienda() {
        return nombreTienda;
    }

    public void setNombreTienda(String nombreTienda) {
        this.nombreTienda = nombreTienda;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }
}
