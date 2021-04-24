/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author oscar
 */
@Entity
@Table(name = "sm_comentario")
@NamedQueries({
	@NamedQuery(name = "SmComentario.findAll", query = "SELECT s FROM SmComentario s"),
	@NamedQuery(name = "SmComentario.findByComId", query = "SELECT s FROM SmComentario s WHERE s.comId = :comId"),
	@NamedQuery(name = "SmComentario.findByComfechaComentario", query = "SELECT s FROM SmComentario s WHERE s.comfechaComentario = :comfechaComentario")})
public class SmComentario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "com_id")
	private Integer comId;
	@Basic(optional = false)
    @Lob
    @Column(name = "com_comentario")
	private String comComentario;
	@Basic(optional = false)
    @Column(name = "com_fechaComentario")
    @Temporal(TemporalType.TIMESTAMP)
	private Date comfechaComentario;
	@JoinColumn(name = "mo_id", referencedColumnName = "mo_id")
    @ManyToOne(optional = false)
	private SmMotel moId;
	@JoinColumn(name = "usr_id", referencedColumnName = "usr_id")
    @ManyToOne(optional = false)
	private SmUsuario usrId;

	public SmComentario() {
	}

	public SmComentario(Integer comId) {
		this.comId = comId;
	}

	public SmComentario(Integer comId, String comComentario, Date comfechaComentario) {
		this.comId = comId;
		this.comComentario = comComentario;
		this.comfechaComentario = comfechaComentario;
	}

	public Integer getComId() {
		return comId;
	}

	public void setComId(Integer comId) {
		this.comId = comId;
	}

	public String getComComentario() {
		return comComentario;
	}

	public void setComComentario(String comComentario) {
		this.comComentario = comComentario;
	}

	public Date getComfechaComentario() {
		return comfechaComentario;
	}

	public void setComfechaComentario(Date comfechaComentario) {
		this.comfechaComentario = comfechaComentario;
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
		hash += (comId != null ? comId.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof SmComentario)) {
			return false;
		}
		SmComentario other = (SmComentario) object;
		if ((this.comId == null && other.comId != null) || (this.comId != null && !this.comId.equals(other.comId))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.sistemaMotelario.core.entity.SmComentario[ comId=" + comId + " ]";
	}
	
}
