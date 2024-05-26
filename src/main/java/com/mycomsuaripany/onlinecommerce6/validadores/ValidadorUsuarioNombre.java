/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycomsuaripany.onlinecommerce6.validadores;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;


@FacesValidator(value = "validadorUsuarioNombre")
public class ValidadorUsuarioNombre implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String valor = (String) o;
        // Validamos el maximo de caractares
        if(valor.length() > 10){
            throw new ValidatorException(new FacesMessage("Debe tener maximo 10 caracteres"));
        }
        
        // Verificar si el nombre está vacío o es nulo
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("El nombre no debe estar vacío"));
        }

        // Verificar si el nombre contiene solo caracteres alfabéticos
        if (!valor.matches("[a-zA-Z]+")) {
            throw new ValidatorException(new FacesMessage("El nombre solo debe contener letras"));
        }

        // Verificar si el nombre comienza con una letra mayúscula
        if (!Character.isUpperCase(valor.charAt(0))) {
            throw new ValidatorException(new FacesMessage("El nombre debe comenzar con una letra mayúscula"));
        }
        
    }
    
}
