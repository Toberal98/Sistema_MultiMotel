/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import javax.persistence.Basic;
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
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_detalle_habitacion")
@NamedQueries({
    @NamedQuery(name = "SmDetalleHabitacion.findAll", query = "SELECT s FROM SmDetalleHabitacion s"),
    @NamedQuery(name = "SmDetalleHabitacion.findByDethId", query = "SELECT s FROM SmDetalleHabitacion s WHERE s.dethId = :dethId"),
    @NamedQuery(name = "SmDetalleHabitacion.findByEtiqueta", query = "SELECT s FROM SmDetalleHabitacion s WHERE s.etiqueta = :etiqueta")})
public class SmDetalleHabitacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "deth_id")
    private Integer dethId;
    @Basic(optional = false)
    @Column(name = "etiqueta")
    private String etiqueta;
    @Basic(optional = false)
    @Lob
    @Column(name = "valor")
    private String valor;
    @JoinColumn(name = "ha_id", referencedColumnName = "ha_id")
    @ManyToOne
    private SmHabitacion haId;

    public SmDetalleHabitacion() {
    }

    public SmDetalleHabitacion(Integer dethId) {
        this.dethId = dethId;
    }

    public SmDetalleHabitacion(Integer dethId, String etiqueta, String valor) {
        this.dethId = dethId;
        this.etiqueta = etiqueta;
        this.valor = valor;
    }

    public Integer getDethId() {
        return dethId;
    }

    public void setDethId(Integer dethId) {
        this.dethId = dethId;
    }

    public String getEtiqueta() {
        return etiqueta;
    }

    public void setEtiqueta(String etiqueta) {
        this.etiqueta = etiqueta;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public SmHabitacion getHaId() {
        return haId;
    }

    public void setHaId(SmHabitacion haId) {
        this.haId = haId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dethId != null ? dethId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmDetalleHabitacion)) {
            return false;
        }
        SmDetalleHabitacion other = (SmDetalleHabitacion) object;
        if ((this.dethId == null && other.dethId != null) || (this.dethId != null && !this.dethId.equals(other.dethId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmDetalleHabitacion[ dethId=" + dethId + " ]";
    }
    
}
