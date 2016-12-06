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

    @EJB
    private UsuarioFacadeLocal usuariofc;
    private Usuario usuario;
    @EJB
    private RolFacadeLocal rolfc;
    private List<Rol> lisrol;
    @EJB
    private EstadoUsuarioFacadeLocal estadfc;
    private List<EstadoUsuario> lisestad;

    public UsuarioManagedBean() {
    }

    public Usuario getUsuario(Integer id) {
        return usuariofc.find(id);
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Rol> getLisrol() {
        lisrol = rolfc.findAll();
        return lisrol;
    }

    public void setLisrol(List<Rol> lisrol) {
        this.lisrol = lisrol;
    }

    public List<EstadoUsuario> getLisestad() {
        lisestad = estadfc.findAll();
        return lisestad;
    }

    public void setLisestad(List<EstadoUsuario> lisestad) {
        this.lisestad = lisestad;
    }

    @PostConstruct
    public void init() {
        usuario = new Usuario();
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

    public List<Usuario> listarUsuario() {
        return usuariofc.findAll();
    }
    
}
