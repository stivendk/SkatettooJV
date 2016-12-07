/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.utilities.converter;

import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.frontend.disenio.controllers.DisenioManagedBean;
import com.skatettoo.frontend.disenio.controllers.EstilosManagedBean;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author SENA
 */
@FacesConverter(forClass = EstiloDisenio.class)
public class DisenioEstiloConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Integer e = Integer.valueOf(value);
        DisenioManagedBean omb = (DisenioManagedBean) context.getApplication().getELResolver().getValue(context.getELContext(), null, "estilosManagedBean");
        
        return omb.getDisenioKey(e);
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        if( value instanceof DisenioManagedBean){
            EstiloDisenio  to = (EstiloDisenio) value;
            return to.getIdEstiloDisenio().toString();
        }
        context.addMessage(null, new FacesMessage("Error al convertir el objeto TipoOrden a String"));
        return null;
    }
    
}
