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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_detalle_motel_usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmDetalleMotelUsuario.findAll", query = "SELECT s FROM SmDetalleMotelUsuario s"),
    @NamedQuery(name = "SmDetalleMotelUsuario.findByDmuId", query = "SELECT s FROM SmDetalleMotelUsuario s WHERE s.dmuId = :dmuId")})
public class SmDetalleMotelUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dmu_id")
    private Integer dmuId;
    @JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne(optional = false)
    private SmMotel moId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
    private SmUsuario usrId;

    public SmDetalleMotelUsuario() {
    }

    public SmDetalleMotelUsuario(Integer dmuId) {
        this.dmuId = dmuId;
    }

    public Integer getDmuId() {
        return dmuId;
    }

    public void setDmuId(Integer dmuId) {
        this.dmuId = dmuId;
    }

    public SmMotel getMoId() {
        return moId;
    }

    public void setMoId(SmMotel moId) {
        this.moId = moId;
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
        hash += (dmuId != null ? dmuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmDetalleMotelUsuario)) {
            return false;
        }
        SmDetalleMotelUsuario other = (SmDetalleMotelUsuario) object;
        if ((this.dmuId == null && other.dmuId != null) || (this.dmuId != null && !this.dmuId.equals(other.dmuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmDetalleMotelUsuario[ dmuId=" + dmuId + " ]";
    }
    
}
