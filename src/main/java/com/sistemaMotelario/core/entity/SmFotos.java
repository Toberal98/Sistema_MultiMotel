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

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_fotos")
@NamedQueries({
    @NamedQuery(name = "SmFotos.findAll", query = "SELECT s FROM SmFotos s"),
    @NamedQuery(name = "SmFotos.findByFotId", query = "SELECT s FROM SmFotos s WHERE s.fotId = :fotId")})
public class SmFotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fot_id")
    private Integer fotId;
    @Basic(optional = false)
    @Lob
    @Column(name = "fh_foto")
    private byte[] fhFoto;
    @Basic(optional = false)
    @Lob
    @Column(name = "fh_descripcion")
    private String fhDescripcion;
    @JoinColumn(name = "ha_id", referencedColumnName = "ha_id")
    @ManyToOne(optional = false)
    private SmHabitacion haId;
    @JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne(optional = false)
    @JsonIgnore
    private SmMotel moId;

    public SmFotos() {
    }

    public SmFotos(Integer fotId) {
        this.fotId = fotId;
    }

    public SmFotos(Integer fotId, byte[] fhFoto, String fhDescripcion) {
        this.fotId = fotId;
        this.fhFoto = fhFoto;
        this.fhDescripcion = fhDescripcion;
    }

    public Integer getFotId() {
        return fotId;
    }

    public void setFotId(Integer fotId) {
        this.fotId = fotId;
    }

    public byte[] getFhFoto() {
        return fhFoto;
    }

    public void setFhFoto(byte[] fhFoto) {
        this.fhFoto = fhFoto;
    }

    public String getFhDescripcion() {
        return fhDescripcion;
    }

    public void setFhDescripcion(String fhDescripcion) {
        this.fhDescripcion = fhDescripcion;
    }

    public SmHabitacion getHaId() {
        return haId;
    }

    public void setHaId(SmHabitacion haId) {
        this.haId = haId;
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
        hash += (fotId != null ? fotId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmFotos)) {
            return false;
        }
        SmFotos other = (SmFotos) object;
        if ((this.fotId == null && other.fotId != null) || (this.fotId != null && !this.fotId.equals(other.fotId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmFotos[ fotId=" + fotId + " ]";
    }
    
}
