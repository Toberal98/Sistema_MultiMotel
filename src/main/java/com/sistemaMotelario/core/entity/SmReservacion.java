/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.OrderBy;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_reservacion")
@NamedQueries({
    @NamedQuery(name = "SmReservacion.findAll", query = "SELECT s FROM SmReservacion s"),
    @NamedQuery(name = "SmReservacion.findByResId", query = "SELECT s FROM SmReservacion s WHERE s.resId = :resId"),
    @NamedQuery(name = "SmReservacion.findByResCantidadApagar", query = "SELECT s FROM SmReservacion s WHERE s.resCantidadApagar = :resCantidadApagar"),
    @NamedQuery(name = "SmReservacion.findByFecha", query = "SELECT s FROM SmReservacion s WHERE s.fecha = :fecha"),
    @NamedQuery(name = "SmReservacion.findByHora", query = "SELECT s FROM SmReservacion s WHERE s.hora = :hora")})
public class SmReservacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "res_id")
    private Integer resId;
    @Basic(optional = false)
    @Column(name = "res_cantidad_apagar")
    private double resCantidadApagar;
    @Basic(optional = false)
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "hora")
    private String hora;
    @JoinColumn(name = "ha_id", referencedColumnName = "ha_id")
    @ManyToOne

    private SmHabitacion haId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private SmUsuario usrId;

    public SmReservacion() {
    }

    public SmReservacion(Integer resId) {
        this.resId = resId;
    }

    public SmReservacion(Integer resId, double resCantidadApagar, Date fecha, String hora) {
        this.resId = resId;
        this.resCantidadApagar = resCantidadApagar;
        this.fecha = fecha;
        this.hora = hora;
    }
	 public SmReservacion( double resCantidadApagar, Date fecha, String hora, SmHabitacion haId, SmUsuario usrId) {
        this.resCantidadApagar = resCantidadApagar;
        this.fecha = fecha;
        this.hora = hora;
		this.haId = haId;
		this.usrId = usrId;
	 }

    public Integer getResId() {
        return resId;
    }

    public void setResId(Integer resId) {
        this.resId = resId;
    }

    public double getResCantidadApagar() {
        return resCantidadApagar;
    }

    public void setResCantidadApagar(double resCantidadApagar) {
        this.resCantidadApagar = resCantidadApagar;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public SmHabitacion getHaId() {
        return haId;
    }

    public void setHaId(SmHabitacion haId) {
        this.haId = haId;
    }

    public SmUsuario getUsrId() {
        return usrId;
    }

    public void setUsrId(SmUsuario usrId) {
        this.usrId = usrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (resId != null ? resId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmReservacion)) {
            return false;
        }
        SmReservacion other = (SmReservacion) object;
        if ((this.resId == null && other.resId != null) || (this.resId != null && !this.resId.equals(other.resId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmReservacion[ resId=" + resId + " ]";
    }
    
}
