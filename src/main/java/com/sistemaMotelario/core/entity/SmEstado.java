/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_estado")
@NamedQueries({
    @NamedQuery(name = "SmEstado.findAll", query = "SELECT s FROM SmEstado s"),
    @NamedQuery(name = "SmEstado.findByEstId", query = "SELECT s FROM SmEstado s WHERE s.estId = :estId"),
    @NamedQuery(name = "SmEstado.findByEstOrden", query = "SELECT s FROM SmEstado s WHERE s.estOrden = :estOrden")})
public class SmEstado implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "est_id")
    private Integer estId;
    @Basic(optional = false)
    @Lob
    @Column(name = "est_estado")
    private String estEstado;
    @Basic(optional = false)
    @Column(name = "est_orden")
    private int estOrden;
    @OneToMany(mappedBy = "esId")
    private List<SmHabitacion> smHabitacionList;

    public SmEstado() {
    }

    public SmEstado(Integer estId) {
        this.estId = estId;
    }

    public SmEstado(Integer estId, String estEstado, int estOrden) {
        this.estId = estId;
        this.estEstado = estEstado;
        this.estOrden = estOrden;
    }

    public Integer getEstId() {
        return estId;
    }

    public void setEstId(Integer estId) {
        this.estId = estId;
    }

    public String getEstEstado() {
        return estEstado;
    }

    public void setEstEstado(String estEstado) {
        this.estEstado = estEstado;
    }

    public int getEstOrden() {
        return estOrden;
    }

    public void setEstOrden(int estOrden) {
        this.estOrden = estOrden;
    }

    public List<SmHabitacion> getSmHabitacionList() {
        return smHabitacionList;
    }

    public void setSmHabitacionList(List<SmHabitacion> smHabitacionList) {
        this.smHabitacionList = smHabitacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (estId != null ? estId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmEstado)) {
            return false;
        }
        SmEstado other = (SmEstado) object;
        if ((this.estId == null && other.estId != null) || (this.estId != null && !this.estId.equals(other.estId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmEstado[ estId=" + estId + " ]";
    }
    
}
