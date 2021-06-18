package com.sistemMotelario.core.pojos;

import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.entity.SmTipoUsuarios;
import com.sistemaMotelario.core.entity.SmUsuario;

public class UsuarioPojo {
	private int idUsuario;
	private String correo;
	private String password;
	private int idMunicipio;
	private int tipoUser;
	public UsuarioPojo() {
		super();
	}
	
	
	public UsuarioPojo(int idUsuario, String correo, String password, int idMunicipio, int tipoUser) {
		super();
		this.idUsuario = idUsuario;
		this.correo = correo;
		this.password = password;
		this.idMunicipio = idMunicipio;
		this.tipoUser = tipoUser;
	}


	public int getIdUsuario() {
		return idUsuario;
	}


	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}


	public String getCorreo() {
		return correo;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public int getIdMunicipio() {
		return idMunicipio;
	}


	public void setIdMunicipio(int idMunicipio) {
		this.idMunicipio = idMunicipio;
	}


	public int getTipoUser() {
		return tipoUser;
	}


	public void setTipoUser(int tipoUser) {
		this.tipoUser = tipoUser;
	}


	public static SmUsuario toEntity(UsuarioPojo pojo) {
		SmUsuario smu = new SmUsuario();
		SmTipoUsuarios tpu = new SmTipoUsuarios();
		SmMunicipio mun = new SmMunicipio();
		smu.setUsrId(pojo.idUsuario);
		smu.setUsrCorreo(pojo.correo);
		smu.setUsrPassword(pojo.password);
		mun.setMunId(pojo.idMunicipio);
		smu.setMunId(mun);
		tpu.setTusrId(pojo.tipoUser);
		smu.setTusrId(tpu);
		return smu;
	}
	
}
