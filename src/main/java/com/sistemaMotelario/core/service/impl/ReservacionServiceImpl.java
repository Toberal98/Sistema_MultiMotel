package com.sistemaMotelario.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaMotelario.core.dao.ReservacionDao;
import com.sistemaMotelario.core.dao.impl.ReservacionDaoImpl;
import com.sistemaMotelario.core.entity.SmReservacion;
import com.sistemaMotelario.core.service.ReservacionService;

@Service
public class ReservacionServiceImpl implements ReservacionService{

	public static Logger log = LoggerFactory.getLogger(ReservacionDaoImpl.class);
	@Autowired
	private ReservacionDao rd;
	@Override
	public List<SmReservacion> findAll() {
		try {
            log.info("Extrayendo reservaciones de la base de datos");
            List<SmReservacion> reservaciones = rd.findAll();
            if (reservaciones == null) {
                    log.warn("No hay reservaciones que mostrar");
                    return null;
            }
            return reservaciones;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}

	@Override
	public List<SmReservacion> findReservation(int idUsuario) {
		try {
            log.info("Extrayendo reservaciones de la base de datos para este usuario");
            List<SmReservacion> reservacionUsuario = rd.findReservation(idUsuario);
            if (reservacionUsuario == null) {
                    log.warn("No hay reservaciones que mostrar para este usuario");
                    return null;
            }
            return reservacionUsuario;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}

	@Override
	public SmReservacion reservacion(SmReservacion reservaciones) {
		try {
			
            log.info("Creando la reservacion");
            SmReservacion reser = rd.reservacion(reservaciones);
            	if (reser == null) {
	                log.warn("no se ha podido reservar");
	                return null;
            		}
            	return reser;
		} catch (Exception e) {
		e.printStackTrace();
		log.error("posible causa: " + e.getCause());
		return null;
	}
	}

}
