/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers.module.disenio;

import com.skatettoo.backend.persistence.entities.Disenio;
import com.skatettoo.backend.persistence.entities.EstiloDisenio;
import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.DisenioFacadeLocal;
import com.skatettoo.backend.persistence.facade.EstiloDisenioFacadeLocal;
import com.skatettoo.backend.persistence.facade.UsuarioFacadeLocal;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;

/**
 *
 * @author StivenDavid
 */
@Named(value = "disenioManagedBean")
@SessionScoped
public class DisenioManagedBean implements Serializable {

    @EJB
    private DisenioFacadeLocal diseniofc;
    private Disenio disenio;
    @EJB
    private EstiloDisenioFacadeLocal estilfc;
    private List<EstiloDisenio> lisest;
    @EJB
    private UsuarioFacadeLocal usuariofc;
    private List<Usuario> lisus;

    public DisenioManagedBean() {
    }

    public Disenio getDisenio() {
        return disenio;
    }

    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    public List<EstiloDisenio> getLisest() {
        lisest = estilfc.findAll();
        return lisest;
    }

    public void setLisest(List<EstiloDisenio> lisest) {
        this.lisest = lisest;
    }

    public List<Usuario> getLisus() {
        lisus = usuariofc.findAll();
        return lisus;
    }

    public void setLisus(List<Usuario> lisus) {
        this.lisus = lisus;
    }
    
    @PostConstruct
    public void init(){
        disenio = new Disenio();
    }
    
    public void registrarDisenio() {
        diseniofc.create(disenio);
    }

    public void eliminarDisenio() {
        diseniofc.remove(disenio);
    }

    public String modificarDisenio() {
        diseniofc.edit(disenio);
        return "";
    }

    public List<Disenio> listarDisenio() {
        return diseniofc.findAll();
    }
}
