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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_motel")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmMotel.findAll", query = "SELECT s FROM SmMotel s"),
    @NamedQuery(name = "SmMotel.findByMoId", query = "SELECT s FROM SmMotel s WHERE s.moId = :moId"),
    @NamedQuery(name = "SmMotel.findByMoLatitud", query = "SELECT s FROM SmMotel s WHERE s.moLatitud = :moLatitud"),
    @NamedQuery(name = "SmMotel.findByMoLongitud", query = "SELECT s FROM SmMotel s WHERE s.moLongitud = :moLongitud"),
    @NamedQuery(name = "SmMotel.findByMohoraApertura", query = "SELECT s FROM SmMotel s WHERE s.mohoraApertura = :mohoraApertura"),
    @NamedQuery(name = "SmMotel.findByMohoraCierre", query = "SELECT s FROM SmMotel s WHERE s.mohoraCierre = :mohoraCierre")})
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
    @Column(name = "mo_fotoPortada")
    private byte[] mofotoPortada;
    @Basic(optional = false)
    @Column(name = "mo_horaApertura")
    private String mohoraApertura;
    @Basic(optional = false)
    @Column(name = "mo_horaCierre")
    private String mohoraCierre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    private List<SmValoracion> smValoracionList;
    @JoinColumn(name = "cat_id", referencedColumnName = "cat_id")
    @ManyToOne(optional = false)
    private SmCategoria catId;
    @JoinColumn(name = "mun_id", referencedColumnName = "mun_id")
    @ManyToOne(optional = false)
    private SmMunicipio munId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    private List<SmComentario> smComentarioList;
    @OneToMany(mappedBy = "moId")
    private List<SmHabitacion> smHabitacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    private List<SmFotos> smFotosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "moId")
    private List<SmDetalleMotelUsuario> smDetalleMotelUsuarioList;

    public SmMotel() {
    }

    public SmMotel(Integer moId) {
        this.moId = moId;
    }

    public SmMotel(Integer moId, String moNombre, String moDireccion, double moLatitud, double moLongitud, byte[] mofotoPortada, String mohoraApertura, String mohoraCierre) {
        this.moId = moId;
        this.moNombre = moNombre;
        this.moDireccion = moDireccion;
        this.moLatitud = moLatitud;
        this.moLongitud = moLongitud;
        this.mofotoPortada = mofotoPortada;
        this.mohoraApertura = mohoraApertura;
        this.mohoraCierre = mohoraCierre;
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

    public byte[] getMofotoPortada() {
        return mofotoPortada;
    }

    public void setMofotoPortada(byte[] mofotoPortada) {
        this.mofotoPortada = mofotoPortada;
    }

    public String getMohoraApertura() {
        return mohoraApertura;
    }

    public void setMohoraApertura(String mohoraApertura) {
        this.mohoraApertura = mohoraApertura;
    }

    public String getMohoraCierre() {
        return mohoraCierre;
    }

    public void setMohoraCierre(String mohoraCierre) {
        this.mohoraCierre = mohoraCierre;
    }

    @XmlTransient
    public List<SmValoracion> getSmValoracionList() {
        return smValoracionList;
    }

    public void setSmValoracionList(List<SmValoracion> smValoracionList) {
        this.smValoracionList = smValoracionList;
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

    @XmlTransient
    public List<SmComentario> getSmComentarioList() {
        return smComentarioList;
    }

    public void setSmComentarioList(List<SmComentario> smComentarioList) {
        this.smComentarioList = smComentarioList;
    }

    @XmlTransient
    public List<SmHabitacion> getSmHabitacionList() {
        return smHabitacionList;
    }

    public void setSmHabitacionList(List<SmHabitacion> smHabitacionList) {
        this.smHabitacionList = smHabitacionList;
    }

    @XmlTransient
    public List<SmFotos> getSmFotosList() {
        return smFotosList;
    }

    public void setSmFotosList(List<SmFotos> smFotosList) {
        this.smFotosList = smFotosList;
    }

    @XmlTransient
    public List<SmDetalleMotelUsuario> getSmDetalleMotelUsuarioList() {
        return smDetalleMotelUsuarioList;
    }

    public void setSmDetalleMotelUsuarioList(List<SmDetalleMotelUsuario> smDetalleMotelUsuarioList) {
        this.smDetalleMotelUsuarioList = smDetalleMotelUsuarioList;
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
