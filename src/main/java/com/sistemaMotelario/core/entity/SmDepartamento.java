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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dell
 */
@Entity
@Table(name = "sm_departamento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmDepartamento.findAll", query = "SELECT s FROM SmDepartamento s"),
    @NamedQuery(name = "SmDepartamento.findByDepId", query = "SELECT s FROM SmDepartamento s WHERE s.depId = :depId")})
public class SmDepartamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "dep_id")
    private Integer depId;
    @Basic(optional = false)
    @Lob
    @Column(name = "dep_nombre")
    private String depNombre;
    @OneToMany(mappedBy = "depId")
    private List<SmMunicipio> smMunicipioList;

    public SmDepartamento() {
    }

    public SmDepartamento(Integer depId) {
        this.depId = depId;
    }

    public SmDepartamento(Integer depId, String depNombre) {
        this.depId = depId;
        this.depNombre = depNombre;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public String getDepNombre() {
        return depNombre;
    }

    public void setDepNombre(String depNombre) {
        this.depNombre = depNombre;
    }

    @XmlTransient
    public List<SmMunicipio> getSmMunicipioList() {
        return smMunicipioList;
    }

    public void setSmMunicipioList(List<SmMunicipio> smMunicipioList) {
        this.smMunicipioList = smMunicipioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (depId != null ? depId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmDepartamento)) {
            return false;
        }
        SmDepartamento other = (SmDepartamento) object;
        if ((this.depId == null && other.depId != null) || (this.depId != null && !this.depId.equals(other.depId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmDepartamento[ depId=" + depId + " ]";
    }
    
}
