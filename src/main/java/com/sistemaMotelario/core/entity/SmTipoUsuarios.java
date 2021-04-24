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
 * @author oscar
 */
@Entity
@Table(name = "sm_tipo_usuarios")
@NamedQueries({
	@NamedQuery(name = "SmTipoUsuarios.findAll", query = "SELECT s FROM SmTipoUsuarios s"),
	@NamedQuery(name = "SmTipoUsuarios.findByTusrId", query = "SELECT s FROM SmTipoUsuarios s WHERE s.tusrId = :tusrId")})
public class SmTipoUsuarios implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "tusr_id")
	private Integer tusrId;
	@Basic(optional = false)
    @Lob
    @Column(name = "tusr_tipoUsuario")
	private String tusrtipoUsuario;
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne
	private SmUsuario usrId;

	public SmTipoUsuarios() {
	}

	public SmTipoUsuarios(Integer tusrId) {
		this.tusrId = tusrId;
	}

	public SmTipoUsuarios(Integer tusrId, String tusrtipoUsuario) {
		this.tusrId = tusrId;
		this.tusrtipoUsuario = tusrtipoUsuario;
	}

	public Integer getTusrId() {
		return tusrId;
	}

	public void setTusrId(Integer tusrId) {
		this.tusrId = tusrId;
	}

	public String getTusrtipoUsuario() {
		return tusrtipoUsuario;
	}

	public void setTusrtipoUsuario(String tusrtipoUsuario) {
		this.tusrtipoUsuario = tusrtipoUsuario;
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
		hash += (tusrId != null ? tusrId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SmTipoUsuarios)) {
			return false;
		}
		SmTipoUsuarios other = (SmTipoUsuarios) object;
		if ((this.tusrId == null && other.tusrId != null) || (this.tusrId != null && !this.tusrId.equals(other.tusrId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sistemaMotelario.core.entity.SmTipoUsuarios[ tusrId=" + tusrId + " ]";
	}
	
}
