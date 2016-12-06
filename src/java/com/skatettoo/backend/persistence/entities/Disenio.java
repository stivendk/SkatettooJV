/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skatettoo.backend.persistence.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author StivenDavid
 */
@Entity
@Table(name = "disenios")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disenio.findAll", query = "SELECT d FROM Disenio d"),
    @NamedQuery(name = "Disenio.findByIdDisenio", query = "SELECT d FROM Disenio d WHERE d.idDisenio = :idDisenio"),
    @NamedQuery(name = "Disenio.findByNombreDisenio", query = "SELECT d FROM Disenio d WHERE d.nombreDisenio = :nombreDisenio"),
    @NamedQuery(name = "Disenio.findBySesionesRecomendadas", query = "SELECT d FROM Disenio d WHERE d.sesionesRecomendadas = :sesionesRecomendadas"),
    @NamedQuery(name = "Disenio.findByPrecioDisenio", query = "SELECT d FROM Disenio d WHERE d.precioDisenio = :precioDisenio")})
public class Disenio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_disenio")
    private Integer idDisenio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nombre_disenio")
    private String nombreDisenio;
    @Lob
    @Column(name = "disenioaAdjunto")
    private byte[] disenioaAdjunto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "sesiones_recomendadas")
    private int sesionesRecomendadas;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio_disenio")
    private int precioDisenio;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "anotaciones")
    private String anotaciones;
    @JoinColumn(name = "id_estilo_disenio", referencedColumnName = "id_estilo_disenio")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EstiloDisenio idEstiloDisenio;
    @JoinColumn(name = "id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;
    @OneToMany(mappedBy = "idDisenio", fetch = FetchType.LAZY)
    private List<Cita> citaList;

    public Disenio() {
    }

    public Disenio(Integer idDisenio) {
        this.idDisenio = idDisenio;
    }

    public Disenio(Integer idDisenio, String nombreDisenio, int sesionesRecomendadas, int precioDisenio, String anotaciones) {
        this.idDisenio = idDisenio;
        this.nombreDisenio = nombreDisenio;
        this.sesionesRecomendadas = sesionesRecomendadas;
        this.precioDisenio = precioDisenio;
        this.anotaciones = anotaciones;
    }

    public Integer getIdDisenio() {
        return idDisenio;
    }

    public void setIdDisenio(Integer idDisenio) {
        this.idDisenio = idDisenio;
    }

    public String getNombreDisenio() {
        return nombreDisenio;
    }

    public void setNombreDisenio(String nombreDisenio) {
        this.nombreDisenio = nombreDisenio;
    }

    public byte[] getDisenioaAdjunto() {
        return disenioaAdjunto;
    }

    public void setDisenioaAdjunto(byte[] disenioaAdjunto) {
        this.disenioaAdjunto = disenioaAdjunto;
    }

    public int getSesionesRecomendadas() {
        return sesionesRecomendadas;
    }

    public void setSesionesRecomendadas(int sesionesRecomendadas) {
        this.sesionesRecomendadas = sesionesRecomendadas;
    }

    public int getPrecioDisenio() {
        return precioDisenio;
    }

    public void setPrecioDisenio(int precioDisenio) {
        this.precioDisenio = precioDisenio;
    }

    public String getAnotaciones() {
        return anotaciones;
    }

    public void setAnotaciones(String anotaciones) {
        this.anotaciones = anotaciones;
    }

    public EstiloDisenio getIdEstiloDisenio() {
        return idEstiloDisenio;
    }

    public void setIdEstiloDisenio(EstiloDisenio idEstiloDisenio) {
        this.idEstiloDisenio = idEstiloDisenio;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @XmlTransient
    public List<Cita> getCitaList() {
        return citaList;
    }

    public void setCitaList(List<Cita> citaList) {
        this.citaList = citaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDisenio != null ? idDisenio.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disenio)) {
            return false;
        }
        Disenio other = (Disenio) object;
        if ((this.idDisenio == null && other.idDisenio != null) || (this.idDisenio != null && !this.idDisenio.equals(other.idDisenio))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.skatettoo.backend.persistence.entities.Disenio[ idDisenio=" + idDisenio + " ]";
    }
    
}
