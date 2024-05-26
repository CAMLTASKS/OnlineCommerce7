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


@FacesValidator(value ="validadorUsuarioCorreo")
public class ValidadorUsuarioCorreo implements Validator {

    @Override
    public void validate(FacesContext fc, UIComponent uic, Object o) throws ValidatorException {
        String valor = (String) o;
        
        // Verificar si el correo está vacío o es nulo
        if (valor == null || valor.trim().isEmpty()) {
            throw new ValidatorException(new FacesMessage("El correo no debe estar vacío"));
        }

        // Verificar si el correo tiene un formato válido
        if (!valor.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$")) {
            throw new ValidatorException(new FacesMessage("El formato del correo no es válido"));
        }
        
    }
    
}
