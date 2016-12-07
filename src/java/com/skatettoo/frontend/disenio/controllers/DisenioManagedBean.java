/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.disenio.controllers;

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

    private Disenio disenio;
    private List<Disenio> ldisenio;
    private EstiloDisenio estad;
    private Usuario usuario;
    @EJB
    private DisenioFacadeLocal diseniofc;
    private EstiloDisenioFacadeLocal estilfc;
    private UsuarioFacadeLocal usuariofc;

    public DisenioManagedBean() {
    }

    public Disenio getDisenio() {
        return disenio;
    }
    
    public Disenio getDisenioKey(Integer id){
        return diseniofc.find(id);
    }
    
    public void setDisenio(Disenio disenio) {
        this.disenio = disenio;
    }

    public List<Disenio> getLdisenio() {
        ldisenio = diseniofc.findAll();
        return ldisenio;
    }

    public void setLdisenio(List<Disenio> ldisenio) {
        this.ldisenio = ldisenio;
    }

    public EstiloDisenio getEstad(Integer id) {
        return estilfc.find(id);
    }

    public void setEstad(EstiloDisenio estad) {
        this.estad = estad;
    }

    public Usuario getUsuario(Integer id) {
        return usuariofc.find(id);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    @PostConstruct
    public void init(){
        disenio = new Disenio();
        usuario = new Usuario();
        estad = new EstiloDisenio();
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
