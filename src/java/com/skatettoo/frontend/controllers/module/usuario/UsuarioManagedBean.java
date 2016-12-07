/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.frontend.controllers.module.usuario;

import com.skatettoo.backend.persistence.entities.EstadoUsuario;
import com.skatettoo.backend.persistence.entities.Rol;
import com.skatettoo.backend.persistence.entities.Usuario;
import com.skatettoo.backend.persistence.facade.EstadoUsuarioFacadeLocal;
import com.skatettoo.backend.persistence.facade.RolFacadeLocal;
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
@Named(value = "usuarioManagedBean")
@SessionScoped
public class UsuarioManagedBean implements Serializable {

    private Usuario usuario;
    private List<Usuario> lisus;
    private EstadoUsuario estad;
    private Rol rol;
    @EJB
    private UsuarioFacadeLocal usuariofc;
    private RolFacadeLocal rolfc;
    private EstadoUsuarioFacadeLocal estadfc;
    
    public UsuarioManagedBean() {
    }

    public Usuario getUsuarioKey(Integer id) {
        return usuariofc.find(id);
    }
    
    public Usuario getUsuario(){
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Usuario> getLisus() {
        lisus = usuariofc.findAll();
        return lisus;
    }

    public void setLisus(List<Usuario> lisus) {
        this.lisus = lisus;
    }

    public EstadoUsuario getEstad(Integer id) {
        return estadfc.find(id);
    }

    public void setEstad(EstadoUsuario estad) {
        this.estad = estad;
    }

    public Rol getRol(Integer id) {
        return rolfc.find(id);
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }
    

    @PostConstruct
    public void init() {
        usuario = new Usuario();
        rol = new Rol();
        estad = new EstadoUsuario();
    }

    public void registrarUsuario() {
        usuariofc.create(usuario);
    }

    public void eliminarUsuario() {
        usuariofc.remove(usuario);
    }

    public void modificarUsuario() {
        usuariofc.edit(usuario);
    }    

}
