/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.Collection;
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

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "sm_habitacion")
@NamedQueries({
	@NamedQuery(name = "SmHabitacion.findAll", query = "SELECT s FROM SmHabitacion s"),
	@NamedQuery(name = "SmHabitacion.findByHaId", query = "SELECT s FROM SmHabitacion s WHERE s.haId = :haId"),
	@NamedQuery(name = "SmHabitacion.findByHanumeroHabitacion", query = "SELECT s FROM SmHabitacion s WHERE s.hanumeroHabitacion = :hanumeroHabitacion"),
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
    @Column(name = "ha_nombreHabitacion")
	private String hanombreHabitacion;
	@Basic(optional = false)
    @Lob
    @Column(name = "ha_tipoDeHabitacion")
	private String hatipoDeHabitacion;
	@Basic(optional = false)
    @Column(name = "ha_numeroHabitacion")
	private int hanumeroHabitacion;
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
	private Collection<SmDetalleHabitacion> smDetalleHabitacionCollection;
	@JoinColumn(name = "es_id", referencedColumnName = "est_id")
    @ManyToOne
	private SmEstado esId;
	@JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne
	private SmMotel moId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "haId")
	private Collection<SmFotos> smFotosCollection;
	@OneToMany(mappedBy = "haId")
	private Collection<SmReservacion> smReservacionCollection;

	public SmHabitacion() {
	}

	public SmHabitacion(Integer haId) {
		this.haId = haId;
	}

	public SmHabitacion(Integer haId, String hanombreHabitacion, String hatipoDeHabitacion, int hanumeroHabitacion, double haPrecio, String haTiempo, String haDescripcion) {
		this.haId = haId;
		this.hanombreHabitacion = hanombreHabitacion;
		this.hatipoDeHabitacion = hatipoDeHabitacion;
		this.hanumeroHabitacion = hanumeroHabitacion;
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

	public String getHanombreHabitacion() {
		return hanombreHabitacion;
	}

	public void setHanombreHabitacion(String hanombreHabitacion) {
		this.hanombreHabitacion = hanombreHabitacion;
	}

	public String getHatipoDeHabitacion() {
		return hatipoDeHabitacion;
	}

	public void setHatipoDeHabitacion(String hatipoDeHabitacion) {
		this.hatipoDeHabitacion = hatipoDeHabitacion;
	}

	public int getHanumeroHabitacion() {
		return hanumeroHabitacion;
	}

	public void setHanumeroHabitacion(int hanumeroHabitacion) {
		this.hanumeroHabitacion = hanumeroHabitacion;
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

	public Collection<SmDetalleHabitacion> getSmDetalleHabitacionCollection() {
		return smDetalleHabitacionCollection;
	}

	public void setSmDetalleHabitacionCollection(Collection<SmDetalleHabitacion> smDetalleHabitacionCollection) {
		this.smDetalleHabitacionCollection = smDetalleHabitacionCollection;
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

	public Collection<SmFotos> getSmFotosCollection() {
		return smFotosCollection;
	}

	public void setSmFotosCollection(Collection<SmFotos> smFotosCollection) {
		this.smFotosCollection = smFotosCollection;
	}

	public Collection<SmReservacion> getSmReservacionCollection() {
		return smReservacionCollection;
	}

	public void setSmReservacionCollection(Collection<SmReservacion> smReservacionCollection) {
		this.smReservacionCollection = smReservacionCollection;
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
