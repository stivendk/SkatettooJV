/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers.module.disenio;

import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.backend.persistence.facade.EstiloDisenioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author SENA
 */
@Named(value = "estilosManagedBean")
@SessionScoped
public class EstilosManagedBean implements Serializable {

    @EJB
    private EstiloDisenioFacadeLocal estilfc;
    private EstiloDisenio estil;

    public EstilosManagedBean() {
    }

    public EstiloDisenio getEstil() {
        return estil;
    }

    public void setEstil(EstiloDisenio estil) {
        this.estil = estil;
    }
    
    @PostConstruct
    public void init(){
        estil = new EstiloDisenio();
    }
    
    public void registrarDisenio(){
        estilfc.create(estil);
    }
    
    public void modificarDisenio(){
        estilfc.edit(estil);
    }
    
    public void eliminarDisenio(){
        estilfc.remove(estil);
    }
    
    public List<EstiloDisenio> listarDisenios(){
        return estilfc.findAll();
    }
}
