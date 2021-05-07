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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_habitacion")
@NamedQueries({
    @NamedQuery(name = "SmHabitacion.findAll", query = "SELECT s FROM SmHabitacion s"),
    @NamedQuery(name = "SmHabitacion.findByHaId", query = "SELECT s FROM SmHabitacion s WHERE s.haId = :haId"),
    @NamedQuery(name = "SmHabitacion.findByHaNumeroHabitacion", query = "SELECT s FROM SmHabitacion s WHERE s.haNumeroHabitacion = :haNumeroHabitacion"),
    @NamedQuery(name = "SmHabitacion.findByHaPrecio", query = "SELECT s FROM SmHabitacion s WHERE s.haPrecio = :haPrecio"),
    @NamedQuery(name = "SmHabitacion.findByHaTiempo", query = "SELECT s FROM SmHabitacion s WHERE s.haTiempo = :haTiempo")})
public class SmHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ha_id")
    private Integer haId;
    @Basic(optional = false)
    @Lob
    @Column(name = "ha_nombre_habitacion")
    private String haNombreHabitacion;
    @Basic(optional = false)
    @Lob
    @Column(name = "ha_tipo_de_habitacion")
    private String haTipoDeHabitacion;
    @Basic(optional = false)
    @Column(name = "ha_numero_habitacion")
    private int haNumeroHabitacion;
    @Basic(optional = false)
    @Column(name = "ha_precio")
    private double haPrecio;
    @Basic(optional = false)
    @Column(name = "ha_tiempo")
    private String haTiempo;
    @Basic(optional = false)
    @Lob
    @Column(name = "ha_descripcion")
    private String haDescripcion;
    @OneToMany(mappedBy = "haId")
    @JsonIgnore
    private List<SmDetalleHabitacion> smDetalleHabitacionList;
    @JoinColumn(name = "es_id", referencedColumnName = "est_id")
    @ManyToOne
    private SmEstado esId;
    @JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne
    @JsonIgnore
    private SmMotel moId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "haId")
    private List<SmFotos> smFotosList;
    @OneToMany(mappedBy = "haId")
    @JsonIgnore
    private List<SmReservacion> smReservacionList;

    public SmHabitacion() {
    }

    public SmHabitacion(Integer haId) {
        this.haId = haId;
    }

    public SmHabitacion(Integer haId, String haNombreHabitacion, String haTipoDeHabitacion, int haNumeroHabitacion, double haPrecio, String haTiempo, String haDescripcion) {
        this.haId = haId;
        this.haNombreHabitacion = haNombreHabitacion;
        this.haTipoDeHabitacion = haTipoDeHabitacion;
        this.haNumeroHabitacion = haNumeroHabitacion;
        this.haPrecio = haPrecio;
        this.haTiempo = haTiempo;
        this.haDescripcion = haDescripcion;
    }

    public Integer getHaId() {
        return haId;
    }

    public void setHaId(Integer haId) {
        this.haId = haId;
    }

    public String getHaNombreHabitacion() {
        return haNombreHabitacion;
    }

    public void setHaNombreHabitacion(String haNombreHabitacion) {
        this.haNombreHabitacion = haNombreHabitacion;
    }

    public String getHaTipoDeHabitacion() {
        return haTipoDeHabitacion;
    }

    public void setHaTipoDeHabitacion(String haTipoDeHabitacion) {
        this.haTipoDeHabitacion = haTipoDeHabitacion;
    }

    public int getHaNumeroHabitacion() {
        return haNumeroHabitacion;
    }

    public void setHaNumeroHabitacion(int haNumeroHabitacion) {
        this.haNumeroHabitacion = haNumeroHabitacion;
    }

    public double getHaPrecio() {
        return haPrecio;
    }

    public void setHaPrecio(double haPrecio) {
        this.haPrecio = haPrecio;
    }

    public String getHaTiempo() {
        return haTiempo;
    }

    public void setHaTiempo(String haTiempo) {
        this.haTiempo = haTiempo;
    }

    public String getHaDescripcion() {
        return haDescripcion;
    }

    public void setHaDescripcion(String haDescripcion) {
        this.haDescripcion = haDescripcion;
    }

    public List<SmDetalleHabitacion> getSmDetalleHabitacionList() {
        return smDetalleHabitacionList;
    }

    public void setSmDetalleHabitacionList(List<SmDetalleHabitacion> smDetalleHabitacionList) {
        this.smDetalleHabitacionList = smDetalleHabitacionList;
    }

    public SmEstado getEsId() {
        return esId;
    }

    public void setEsId(SmEstado esId) {
        this.esId = esId;
    }

    public SmMotel getMoId() {
        return moId;
    }

    public void setMoId(SmMotel moId) {
        this.moId = moId;
    }

    public List<SmFotos> getSmFotosList() {
        return smFotosList;
    }

    public void setSmFotosList(List<SmFotos> smFotosList) {
        this.smFotosList = smFotosList;
    }

    public List<SmReservacion> getSmReservacionList() {
        return smReservacionList;
    }

    public void setSmReservacionList(List<SmReservacion> smReservacionList) {
        this.smReservacionList = smReservacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (haId != null ? haId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmHabitacion)) {
            return false;
        }
        SmHabitacion other = (SmHabitacion) object;
        if ((this.haId == null && other.haId != null) || (this.haId != null && !this.haId.equals(other.haId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmHabitacion[ haId=" + haId + " ]";
    }
    
}
