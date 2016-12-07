/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.controllers;

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
    private List<EstiloDisenio> lestil;

    public EstilosManagedBean() {
    }

    public EstiloDisenio getEstil() {
        return estil;
    }

    public void setEstil(EstiloDisenio estil) {
        this.estil = estil;
    }
    public List<EstiloDisenio> getLestil() {
        lestil = estilfc.findAll();
        return lestil;
    }

    public void setLestil(List<EstiloDisenio> lestil) {
        this.lestil = lestil;
    }
    
    @PostConstruct
    public void init(){
        estil = new EstiloDisenio();
    }
    
    public void registrarEstilo(){
        estilfc.create(estil);
    }
    
    public void modificarEstilo(){
        estilfc.edit(estil);
    }
    
    public void eliminarEstilo(){
        estilfc.remove(estil);
    }
    
    public EstiloDisenio getEstilo(Integer id){
        return estilfc.find(id);
    }
    
    public String actualizarEstilo(EstiloDisenio d){
        estil = d;
        return "/pages/actEstl";
    }

}
