/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemMotelario.core.pojos;

import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmReservacion;
import com.sistemaMotelario.core.entity.SmUsuario;
import java.util.Date;

/**
 *
 * @author oscar
 */
public class ReservacionPojo {
	private Integer resId;
    private double resCantidadPagar;
    private Date fecha;
    private String hora;
    private Integer haId;
    private Integer UsrId;

	public ReservacionPojo(Integer resId, double resCantidadPagar, Date fecha, String hora, Integer haId, Integer UsrId) {
		this.resId = resId;
		this.resCantidadPagar = resCantidadPagar;
		this.fecha = fecha;
		this.hora = hora;
		this.haId = haId;
		this.UsrId = UsrId;
	}

	public ReservacionPojo() {
	}

	public Integer getResId() {
		return resId;
	}

	public void setResId(Integer resId) {
		this.resId = resId;
	}

	public double getResCantidadPagar() {
		return resCantidadPagar;
	}

	public void setResCantidadPagar(double resCantidadPagar) {
		this.resCantidadPagar = resCantidadPagar;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Integer getHaId() {
		return haId;
	}

	public void setHaId(Integer haId) {
		this.haId = haId;
	}

	public Integer getUsrId() {
		return UsrId;
	}

	public void setUsrId(Integer UsrId) {
		this.UsrId = UsrId;
	}
	
	public SmReservacion toEntity(ReservacionPojo pojo){
		SmHabitacion habitacion = new SmHabitacion();
		SmUsuario us = new SmUsuario();
		habitacion.setHaId(pojo.haId);
		us.setUsrId(pojo.UsrId);
		return new SmReservacion(pojo.resCantidadPagar, pojo.fecha, pojo.hora, habitacion, us);
		
	} 
}
