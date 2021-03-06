package com.sistemaMotelario.core.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.sistemaMotelario.core.entity.SmReservacion;

public interface ReservacionService {
	public abstract List<SmReservacion> findAll();
	public abstract List<SmReservacion> findReservation(int idUsuario);
	public abstract  ResponseEntity reservacion(SmReservacion reservaciones);
}
