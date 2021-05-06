/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_motel")
@NamedQueries({
    @NamedQuery(name = "SmMotel.findAll", query = "SELECT s FROM SmMotel s"),
    @NamedQuery(name = "SmMotel.findByMoId", query = "SELECT s FROM SmMotel s WHERE s.moId = :moId"),
    @NamedQuery(name = "SmMotel.findByMoLatitud", query = "SELECT s FROM SmMotel s WHERE s.moLatitud = :moLatitud"),
    @NamedQuery(name = "SmMotel.findByMoLongitud", query = "SELECT s FROM SmMotel s WHERE s.moLongitud = :moLongitud"),
    @NamedQuery(name = "SmMotel.findByMoHoraApertura", query = "SELECT s FROM SmMotel s WHERE s.moHoraApertura = :moHoraApertura"),
    @NamedQuery(name = "SmMotel.findByMoHoraCierre", query = "SELECT s FROM SmMotel s WHERE s.moHoraCierre = :moHoraCierre")})
public class SmMotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mo_id")
    private Integer moId;
    @Basic(optional = false)
    @Lob
    @Column(name = "mo_nombre")
    private String moNombre;
    @Basic(optional = false)
    @Lob
    @Column(name = "mo_direccion")
    private String moDireccion;
    @Basic(optional = false)
    @Column(name = "mo_latitud")
    private double moLatitud;
    @Basic(optional = false)
    @Column(name = "mo_longitud")
    private double moLongitud;
    @Basic(optional = false)
    @Lob
    @Column(name = "mo_foto_portada")
    private byte[] moFotoPortada;
    @Basic(optional = false)
    @Column(name = "mo_hora_apertura")
    private String moHoraApertura;
    @Basic(optional = false)
    @Column(name = "mo_hora_cierre")
    private String moHoraCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    private List<SmValoracion> smValoracionList;
    @OneToMany(mappedBy = "moId")
    @JsonIgnore
    private List<SmAccesosUsuarioMotel> smAccesosUsuarioMotelList;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private SmCategoria catId;
    @JoinColumn(name = "mun_id", referencedColumnName = "mun_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private SmMunicipio munId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    @JsonIgnore
    private List<SmComentario> smComentarioList;
    @OneToMany(mappedBy = "moId")
    @JsonIgnore
    private List<SmHabitacion> smHabitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    @JsonIgnore
    private List<SmFotos> smFotosList;
    @Transient
    private double rating; 

    public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public SmMotel() {
    }

    public SmMotel(Integer moId) {
        this.moId = moId;
    }

    public SmMotel(Integer moId, String moNombre, String moDireccion, double moLatitud, double moLongitud, byte[] moFotoPortada, String moHoraApertura, String moHoraCierre) {
        this.moId = moId;
        this.moNombre = moNombre;
        this.moDireccion = moDireccion;
        this.moLatitud = moLatitud;
        this.moLongitud = moLongitud;
        this.moFotoPortada = moFotoPortada;
        this.moHoraApertura = moHoraApertura;
        this.moHoraCierre = moHoraCierre;
    }

    public Integer getMoId() {
        return moId;
    }

    public void setMoId(Integer moId) {
        this.moId = moId;
    }

    public String getMoNombre() {
        return moNombre;
    }

    public void setMoNombre(String moNombre) {
        this.moNombre = moNombre;
    }

    public String getMoDireccion() {
        return moDireccion;
    }

    public void setMoDireccion(String moDireccion) {
        this.moDireccion = moDireccion;
    }

    public double getMoLatitud() {
        return moLatitud;
    }

    public void setMoLatitud(double moLatitud) {
        this.moLatitud = moLatitud;
    }

    public double getMoLongitud() {
        return moLongitud;
    }

    public void setMoLongitud(double moLongitud) {
        this.moLongitud = moLongitud;
    }

    public byte[] getMoFotoPortada() {
        return moFotoPortada;
    }

    public void setMoFotoPortada(byte[] moFotoPortada) {
        this.moFotoPortada = moFotoPortada;
    }

    public String getMoHoraApertura() {
        return moHoraApertura;
    }

    public void setMoHoraApertura(String moHoraApertura) {
        this.moHoraApertura = moHoraApertura;
    }

    public String getMoHoraCierre() {
        return moHoraCierre;
    }

    public void setMoHoraCierre(String moHoraCierre) {
        this.moHoraCierre = moHoraCierre;
    }

    public List<SmValoracion> getSmValoracionList() {
        return smValoracionList;
    }

    public void setSmValoracionList(List<SmValoracion> smValoracionList) {
        this.smValoracionList = smValoracionList;
    }

    public List<SmAccesosUsuarioMotel> getSmAccesosUsuarioMotelList() {
        return smAccesosUsuarioMotelList;
    }

    public void setSmAccesosUsuarioMotelList(List<SmAccesosUsuarioMotel> smAccesosUsuarioMotelList) {
        this.smAccesosUsuarioMotelList = smAccesosUsuarioMotelList;
    }

    public SmCategoria getCatId() {
        return catId;
    }

    public void setCatId(SmCategoria catId) {
        this.catId = catId;
    }

    public SmMunicipio getMunId() {
        return munId;
    }

    public void setMunId(SmMunicipio munId) {
        this.munId = munId;
    }

    public List<SmComentario> getSmComentarioList() {
        return smComentarioList;
    }

    public void setSmComentarioList(List<SmComentario> smComentarioList) {
        this.smComentarioList = smComentarioList;
    }

    public List<SmHabitacion> getSmHabitacionList() {
        return smHabitacionList;
    }

    public void setSmHabitacionList(List<SmHabitacion> smHabitacionList) {
        this.smHabitacionList = smHabitacionList;
    }

    public List<SmFotos> getSmFotosList() {
        return smFotosList;
    }

    public void setSmFotosList(List<SmFotos> smFotosList) {
        this.smFotosList = smFotosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (moId != null ? moId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmMotel)) {
            return false;
        }
        SmMotel other = (SmMotel) object;
        if ((this.moId == null && other.moId != null) || (this.moId != null && !this.moId.equals(other.moId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmMotel[ moId=" + moId + " ]";
    }
    
}
