/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.controller;

import javax.inject.Named;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import org.primefaces.model.badge.BadgeModel;
import org.primefaces.model.badge.DefaultBadgeModel;

/**
 *
 * @author Torre
 */
@Named(value = "controllerMenu")
@ViewScoped
public class ControllerMenu implements Serializable {

    private BadgeModel badgeModel;

    @PostConstruct
    public void init() {
        badgeModel = DefaultBadgeModel.builder()
                .severity("danger")
                .build();
    }

    public BadgeModel getBadgeModel() {
        return badgeModel;
    }
    
}
