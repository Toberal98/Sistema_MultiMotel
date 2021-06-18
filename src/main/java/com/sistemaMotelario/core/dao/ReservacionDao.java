package com.sistemaMotelario.core.dao;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sistemaMotelario.core.entity.SmReservacion;
public interface ReservacionDao {
	
	public abstract List<SmReservacion> findAll();
	public abstract List<SmReservacion> findReservation(int idUsuario);
	public abstract  ResponseEntity reservacion(SmReservacion reservaciones);
}
