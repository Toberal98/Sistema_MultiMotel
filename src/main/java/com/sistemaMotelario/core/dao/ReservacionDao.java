package com.sistemaMotelario.core.dao;

import java.util.List;

import com.sistemaMotelario.core.entity.SmReservacion;
public interface ReservacionDao {
	
	public abstract List<SmReservacion> findAll();
	public abstract List<SmReservacion> findReservation(int idUsuario);
	public abstract  SmReservacion reservacion(SmReservacion reservaciones);
}
