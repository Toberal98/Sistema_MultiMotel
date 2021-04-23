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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_municipio")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmMunicipio.findAll", query = "SELECT s FROM SmMunicipio s"),
    @NamedQuery(name = "SmMunicipio.findByMunId", query = "SELECT s FROM SmMunicipio s WHERE s.munId = :munId")})
public class SmMunicipio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "mun_id")
    private Integer munId;
    @Basic(optional = false)
    @Lob
    @Column(name = "mun_nombre")
    private String munNombre;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "munId")
    private List<SmMotel> smMotelList;
    @OneToMany(mappedBy = "munId")
    private List<SmUsuario> smUsuarioList;
    @JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
    @ManyToOne
    private SmDepartamento depId;

    public SmMunicipio() {
    }

    public SmMunicipio(Integer munId) {
        this.munId = munId;
    }

    public SmMunicipio(Integer munId, String munNombre) {
        this.munId = munId;
        this.munNombre = munNombre;
    }

    public Integer getMunId() {
        return munId;
    }

    public void setMunId(Integer munId) {
        this.munId = munId;
    }

    public String getMunNombre() {
        return munNombre;
    }

    public void setMunNombre(String munNombre) {
        this.munNombre = munNombre;
    }

    @XmlTransient
    public List<SmMotel> getSmMotelList() {
        return smMotelList;
    }

    public void setSmMotelList(List<SmMotel> smMotelList) {
        this.smMotelList = smMotelList;
    }

    @XmlTransient
    public List<SmUsuario> getSmUsuarioList() {
        return smUsuarioList;
    }

    public void setSmUsuarioList(List<SmUsuario> smUsuarioList) {
        this.smUsuarioList = smUsuarioList;
    }

    public SmDepartamento getDepId() {
        return depId;
    }

    public void setDepId(SmDepartamento depId) {
        this.depId = depId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (munId != null ? munId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmMunicipio)) {
            return false;
        }
        SmMunicipio other = (SmMunicipio) object;
        if ((this.munId == null && other.munId != null) || (this.munId != null && !this.munId.equals(other.munId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmMunicipio[ munId=" + munId + " ]";
    }
    
}
