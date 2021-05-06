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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_valoracion")
@NamedQueries({
    @NamedQuery(name = "SmValoracion.findAll", query = "SELECT s FROM SmValoracion s"),
    @NamedQuery(name = "SmValoracion.findByValId", query = "SELECT s FROM SmValoracion s WHERE s.valId = :valId"),
    @NamedQuery(name = "SmValoracion.findByValValoracion", query = "SELECT s FROM SmValoracion s WHERE s.valValoracion = :valValoracion")})
public class SmValoracion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "val_id")
    private Integer valId;
    @Basic(optional = false)
    @Column(name = "val_valoracion")
    private int valValoracion;
    @JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private SmMotel moId;

    public SmValoracion() {
    }

    public SmValoracion(Integer valId) {
        this.valId = valId;
    }

    public SmValoracion(Integer valId, int valValoracion) {
        this.valId = valId;
        this.valValoracion = valValoracion;
    }

    public Integer getValId() {
        return valId;
    }

    public void setValId(Integer valId) {
        this.valId = valId;
    }

    public int getValValoracion() {
        return valValoracion;
    }

    public void setValValoracion(int valValoracion) {
        this.valValoracion = valValoracion;
    }

    public SmMotel getMoId() {
        return moId;
    }

    public void setMoId(SmMotel moId) {
        this.moId = moId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (valId != null ? valId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmValoracion)) {
            return false;
        }
        SmValoracion other = (SmValoracion) object;
        if ((this.valId == null && other.valId != null) || (this.valId != null && !this.valId.equals(other.valId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmValoracion[ valId=" + valId + " ]";
    }
    
}
