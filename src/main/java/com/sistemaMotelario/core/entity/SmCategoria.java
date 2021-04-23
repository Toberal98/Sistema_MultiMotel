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
@Table(name = "sm_categoria")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SmCategoria.findAll", query = "SELECT s FROM SmCategoria s"),
    @NamedQuery(name = "SmCategoria.findByCatId", query = "SELECT s FROM SmCategoria s WHERE s.catId = :catId")})
public class SmCategoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cat_id")
    private Integer catId;
    @Basic(optional = false)
    @Lob
    @Column(name = "cat_tipo")
    private String catTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "catId")
    private List<SmMotel> smMotelList;

    public SmCategoria() {
    }

    public SmCategoria(Integer catId) {
        this.catId = catId;
    }

    public SmCategoria(Integer catId, String catTipo) {
        this.catId = catId;
        this.catTipo = catTipo;
    }

    public Integer getCatId() {
        return catId;
    }

    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    public String getCatTipo() {
        return catTipo;
    }

    public void setCatTipo(String catTipo) {
        this.catTipo = catTipo;
    }

    @XmlTransient
    public List<SmMotel> getSmMotelList() {
        return smMotelList;
    }

    public void setSmMotelList(List<SmMotel> smMotelList) {
        this.smMotelList = smMotelList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (catId != null ? catId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SmCategoria)) {
            return false;
        }
        SmCategoria other = (SmCategoria) object;
        if ((this.catId == null && other.catId != null) || (this.catId != null && !this.catId.equals(other.catId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.sistemaMotelario.core.entity.SmCategoria[ catId=" + catId + " ]";
    }
    
}
