/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.entity;

import java.io.Serializable;
import java.util.Collection;
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
 * @author oscar
 */
@Entity
@Table(name = "sm_usuario")
@NamedQueries({
	@NamedQuery(name = "SmUsuario.findAll", query = "SELECT s FROM SmUsuario s"),
	@NamedQuery(name = "SmUsuario.findByUsrId", query = "SELECT s FROM SmUsuario s WHERE s.usrId = :usrId"),
	@NamedQuery(name = "SmUsuario.findByUsrEdad", query = "SELECT s FROM SmUsuario s WHERE s.usrEdad = :usrEdad")})
public class SmUsuario implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "usr_id")
	private Integer usrId;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_nombre")
	private String usrNombre;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_apellido")
	private String usrApellido;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_genero")
	private String usrGenero;
	@Basic(optional = false)
    @Column(name = "usr_edad")
	private int usrEdad;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_correo")
	private String usrCorreo;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_username")
	private String usrUsername;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_password")
	private String usrPassword;
	@Basic(optional = false)
    @Lob
    @Column(name = "usr_telefono")
	private String usrTelefono;
	@JoinColumn(name = "mun_id", referencedColumnName = "mun_id")
    @ManyToOne
	private SmMunicipio munId;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
	private Collection<SmComentario> smComentarioCollection;
	@OneToMany(mappedBy = "usrId")
	private Collection<SmTipoUsuarios> smTipoUsuariosCollection;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "usrId")
	private Collection<SmDetalleMotelUsuario> smDetalleMotelUsuarioCollection;
	@OneToMany(mappedBy = "usrId")
	private Collection<SmReservacion> smReservacionCollection;

	public SmUsuario() {
	}

	public SmUsuario(Integer usrId) {
		this.usrId = usrId;
	}

	public SmUsuario(Integer usrId, String usrNombre, String usrApellido, String usrGenero, int usrEdad, String usrCorreo, String usrUsername, String usrPassword, String usrTelefono) {
		this.usrId = usrId;
		this.usrNombre = usrNombre;
		this.usrApellido = usrApellido;
		this.usrGenero = usrGenero;
		this.usrEdad = usrEdad;
		this.usrCorreo = usrCorreo;
		this.usrUsername = usrUsername;
		this.usrPassword = usrPassword;
		this.usrTelefono = usrTelefono;
	}

	public Integer getUsrId() {
		return usrId;
	}

	public void setUsrId(Integer usrId) {
		this.usrId = usrId;
	}

	public String getUsrNombre() {
		return usrNombre;
	}

	public void setUsrNombre(String usrNombre) {
		this.usrNombre = usrNombre;
	}

	public String getUsrApellido() {
		return usrApellido;
	}

	public void setUsrApellido(String usrApellido) {
		this.usrApellido = usrApellido;
	}

	public String getUsrGenero() {
		return usrGenero;
	}

	public void setUsrGenero(String usrGenero) {
		this.usrGenero = usrGenero;
	}

	public int getUsrEdad() {
		return usrEdad;
	}

	public void setUsrEdad(int usrEdad) {
		this.usrEdad = usrEdad;
	}

	public String getUsrCorreo() {
		return usrCorreo;
	}

	public void setUsrCorreo(String usrCorreo) {
		this.usrCorreo = usrCorreo;
	}

	public String getUsrUsername() {
		return usrUsername;
	}

	public void setUsrUsername(String usrUsername) {
		this.usrUsername = usrUsername;
	}

	public String getUsrPassword() {
		return usrPassword;
	}

	public void setUsrPassword(String usrPassword) {
		this.usrPassword = usrPassword;
	}

	public String getUsrTelefono() {
		return usrTelefono;
	}

	public void setUsrTelefono(String usrTelefono) {
		this.usrTelefono = usrTelefono;
	}

	public SmMunicipio getMunId() {
		return munId;
	}

	public void setMunId(SmMunicipio munId) {
		this.munId = munId;
	}

	public Collection<SmComentario> getSmComentarioCollection() {
		return smComentarioCollection;
	}

	public void setSmComentarioCollection(Collection<SmComentario> smComentarioCollection) {
		this.smComentarioCollection = smComentarioCollection;
	}

	public Collection<SmTipoUsuarios> getSmTipoUsuariosCollection() {
		return smTipoUsuariosCollection;
	}

	public void setSmTipoUsuariosCollection(Collection<SmTipoUsuarios> smTipoUsuariosCollection) {
		this.smTipoUsuariosCollection = smTipoUsuariosCollection;
	}

	public Collection<SmDetalleMotelUsuario> getSmDetalleMotelUsuarioCollection() {
		return smDetalleMotelUsuarioCollection;
	}

	public void setSmDetalleMotelUsuarioCollection(Collection<SmDetalleMotelUsuario> smDetalleMotelUsuarioCollection) {
		this.smDetalleMotelUsuarioCollection = smDetalleMotelUsuarioCollection;
	}

	public Collection<SmReservacion> getSmReservacionCollection() {
		return smReservacionCollection;
	}

	public void setSmReservacionCollection(Collection<SmReservacion> smReservacionCollection) {
		this.smReservacionCollection = smReservacionCollection;
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
