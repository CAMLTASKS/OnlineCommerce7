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

@FacesValidator (value = "validadorUsuarioPassword")
public class ValidadorPassword implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String valor = (String) o;
        
        // Verificar si la contraseña tiene al menos 8 caracteres
        if (valor.length() < 8) {
            throw new ValidatorException(new FacesMessage("La contraseña debe tener al menos 8 caracteres"));
        }

        // Verificar si la contraseña contiene al menos una letra mayúscula
        if (!valor.matches(".*[A-Z].*")) {
            throw new ValidatorException(new FacesMessage("La contraseña debe contener al menos una letra mayúscula"));
        }

        // Verificar si la contraseña contiene al menos una letra minúscula
        if (!valor.matches(".*[a-z].*")) {
            throw new ValidatorException(new FacesMessage("La contraseña debe contener al menos una letra minúscula"));
        }

        // Verificar si la contraseña contiene al menos un número
        if (!valor.matches(".*[0-9].*")) {
            throw new ValidatorException(new FacesMessage("La contraseña debe contener al menos un número"));
        }

        // Verificar si la contraseña contiene al menos un carácter especial
        if (!valor.matches(".*[@#\\$%^&+=!].*")) {
            throw new ValidatorException(new FacesMessage("La contraseña debe contener al menos un carácter especial"));
        }
        
    }
    
}
