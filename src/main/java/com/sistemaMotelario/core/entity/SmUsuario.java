/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_usuario")
@NamedQueries({
    @NamedQuery(name = "SmUsuario.findAll", query = "SELECT s FROM SmUsuario s"),
    @NamedQuery(name = "SmUsuario.findByUsrId", query = "SELECT s FROM SmUsuario s WHERE s.usrId = :usrId")})
public class SmUsuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
    private Integer usrId;
    @Basic(optional = false)
    @Lob
    @Column(name = "usr_correo")
    private String usrCorreo;
    @Basic(optional = false)
    @Lob
    @Column(name = "usr_password")
    private String usrPassword;
    @OneToMany(mappedBy = "usrId")
    private List<SmAccesosUsuarioMotel> smAccesosUsuarioMotelList;
    @JoinColumn(name = "mun_id", referencedColumnName = "mun_id")
    @ManyToOne
    private SmMunicipio munId;
    @JoinColumn(name = "tusr_id", referencedColumnName = "tusr_id")
    @ManyToOne
    private SmTipoUsuarios tusrId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    @JsonIgnore
    private List<SmComentario> smComentarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
    @JsonIgnore
    private List<SmDetalleMotelUsuario> smDetalleMotelUsuarioList;
    @JsonIgnore
    @OneToMany(mappedBy = "usrId")
    private List<SmReservacion> smReservacionList;

    public SmUsuario() {
    }

    public SmUsuario(Integer usrId) {
        this.usrId = usrId;
    }

    public SmUsuario(Integer usrId, String usrCorreo, String usrPassword) {
        this.usrId = usrId;
        this.usrCorreo = usrCorreo;
        this.usrPassword = usrPassword;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrCorreo() {
        return usrCorreo;
    }

    public void setUsrCorreo(String usrCorreo) {
        this.usrCorreo = usrCorreo;
    }

    public String getUsrPassword() {
        return usrPassword;
    }

    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }

    public List<SmAccesosUsuarioMotel> getSmAccesosUsuarioMotelList() {
        return smAccesosUsuarioMotelList;
    }

    public void setSmAccesosUsuarioMotelList(List<SmAccesosUsuarioMotel> smAccesosUsuarioMotelList) {
        this.smAccesosUsuarioMotelList = smAccesosUsuarioMotelList;
    }

    public SmMunicipio getMunId() {
        return munId;
    }

    public void setMunId(SmMunicipio munId) {
        this.munId = munId;
    }

    public SmTipoUsuarios getTusrId() {
        return tusrId;
    }

    public void setTusrId(SmTipoUsuarios tusrId) {
        this.tusrId = tusrId;
    }

    public List<SmComentario> getSmComentarioList() {
        return smComentarioList;
    }

    public void setSmComentarioList(List<SmComentario> smComentarioList) {
        this.smComentarioList = smComentarioList;
    }

    public List<SmDetalleMotelUsuario> getSmDetalleMotelUsuarioList() {
        return smDetalleMotelUsuarioList;
    }

    public void setSmDetalleMotelUsuarioList(List<SmDetalleMotelUsuario> smDetalleMotelUsuarioList) {
        this.smDetalleMotelUsuarioList = smDetalleMotelUsuarioList;
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
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmUsuario)) {
            return false;
        }
        SmUsuario other = (SmUsuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmUsuario[ usrId=" + usrId + " ]";
    }
    
}
