/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers.module.usuario;

import com.skatettoo.backend.persistence.entities.Localidad;
import com.skatettoo.backend.persistence.facade.LocalidadFacadeLocal;
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
@Named(value = "localidadManagedBean")
@SessionScoped
public class LocalidadManagedBean implements Serializable {

    /**
     * Creates a new instance of LocalidadManagedBean
     */
    public LocalidadManagedBean() {
    }
    
    private Localidad localidad;
    @EJB
    private LocalidadFacadeLocal lfl;

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
        
    @PostConstruct
    public void init(){
        localidad = new Localidad();
    }
    
    public void registrarLocalidad(){
        lfl.create(localidad);
    }
    
    public List<Localidad> listarLocalidad(){
        return lfl.findAll();
    }
    
    public void eliminarCita(){
        lfl.remove(localidad);
    }
}
