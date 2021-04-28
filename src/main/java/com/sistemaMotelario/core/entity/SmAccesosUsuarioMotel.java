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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_accesos_usuario_motel")
@NamedQueries({
    @NamedQuery(name = "SmAccesosUsuarioMotel.findAll", query = "SELECT s FROM SmAccesosUsuarioMotel s"),
    @NamedQuery(name = "SmAccesosUsuarioMotel.findByAccid", query = "SELECT s FROM SmAccesosUsuarioMotel s WHERE s.accid = :accid")})
public class SmAccesosUsuarioMotel implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Acc_id")
    private Integer accid;
    @JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne
    private SmMotel moId;
    @JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private SmUsuario usrId;

    public SmAccesosUsuarioMotel() {
    }

    public SmAccesosUsuarioMotel(Integer accid) {
        this.accid = accid;
    }

    public Integer getAccid() {
        return accid;
    }

    public void setAccid(Integer accid) {
        this.accid = accid;
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
        hash += (accid != null ? accid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmAccesosUsuarioMotel)) {
            return false;
        }
        SmAccesosUsuarioMotel other = (SmAccesosUsuarioMotel) object;
        if ((this.accid == null && other.accid != null) || (this.accid != null && !this.accid.equals(other.accid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmAccesosUsuarioMotel[ accid=" + accid + " ]";
    }
    
}
