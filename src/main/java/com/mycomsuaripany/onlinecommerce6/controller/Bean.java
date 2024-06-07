/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.controller;

import com.mycomsuaripany.onlinecommerce6.modules.TiendaFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.modules.VentasFacadeLocal;
import com.mycomsuaripany.onlinecommerce6.reportes.ReportesVentas;
import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.pie.PieChartDataSet;
import org.primefaces.model.charts.pie.PieChartModel;

/**
 *
 * @author Torre
 */
@Named(value = "bean")
@ViewScoped
public class Bean implements Serializable {

    private PieChartModel pieModel;
    @EJB
    private VentasFacadeLocal vfl;
    
    @PostConstruct
    public void init() {
        pieModel = new PieChartModel();
        ChartData data = new ChartData();
        PieChartDataSet dataSet = new PieChartDataSet();
        List<String> labels = new ArrayList<>();
        List<Number> values = new ArrayList<>();

        for (ReportesVentas item : this.vfl.datosGrafico()) {
            values.add(item.getTotal());
            labels.add(item.getNombreTienda());
        }
       
        dataSet.setData(values);
        data.addChartDataSet(dataSet);
        data.setLabels(labels);
        pieModel.setData(data);

//        List<String> bgColors = new ArrayList<>();
//        bgColors.add("rgb(255, 99, 132)");
//        bgColors.add("rgb(54, 162, 235)");
//        bgColors.add("rgb(255, 205, 86)");
//        dataSet.setBackgroundColor(bgColors);



//        List<String> labels = new ArrayList<>();
//        labels.add("Red");
//        labels.add("Blue");
//        labels.add("Yellow");

    }

    public PieChartModel getPieModel() {
        return pieModel;
    }
    
    public int TotalVentas(){
        try {
          return this.vfl.count();

        } catch (Exception e) {
        }
        return 0;
    }

}
