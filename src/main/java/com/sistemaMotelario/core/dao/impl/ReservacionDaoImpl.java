package com.sistemaMotelario.core.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistemaMotelario.core.dao.ReservacionDao;
import com.sistemaMotelario.core.entity.SmEstado;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmReservacion;
import com.sistemaMotelario.core.entity.SmUsuario;
import com.sistemaMotelario.core.repository.EstadoRepository;
import com.sistemaMotelario.core.repository.HabitacionRepository;
import com.sistemaMotelario.core.repository.ReservacionRepository;
import org.springframework.data.jpa.repository.Modifying;

@Component
public class ReservacionDaoImpl implements ReservacionDao{

	 public static Logger log = LoggerFactory.getLogger(ReservacionDaoImpl.class);
	@Autowired
	private ReservacionRepository reservacion;
	@Autowired
	private HabitacionRepository repoHabitacion;
	@Autowired 
	private EstadoRepository repoEstado;
	@Override
	public List<SmReservacion> findAll() {
		try {
            log.info("Extrayendo reservaciones de la base de datos");
            List<SmReservacion> r = reservacion.findAll();
            if (r == null) {
                    log.warn("No hay reservaciones que mostrar");
                    return null;
            }
		
            return r;
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
            List<SmReservacion> r = reservacion.findByIdUsuario(idUsuario);
            if (r == null) {
                    log.warn("No hay reservaciones que mostrar para este usuario");
                    return null;
            }
				for (SmReservacion smReservacion : r) {
				SmUsuario us = new SmUsuario();
				us.setUsrCorreo(smReservacion.getUsrId().getUsrCorreo());
				us.setMunId(smReservacion.getUsrId().getMunId());
				smReservacion.setUsrId(us);
				smReservacion.getHaId().setSmFotosList(null);
			}
            return r;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}
    @Modifying
	@Override
	public SmReservacion reservacion(SmReservacion reservaciones) {
		try {
			
            log.info("Creando la reservacion");
            SmReservacion rsrv = reservacion.save(reservaciones);
			log.info("Actualizando estado de la habitacion");
			SmHabitacion ha = new SmHabitacion();
			SmEstado estado = repoEstado.findByEstId(2);
			ha.setHaId(reservaciones.getHaId().getHaId());
			ha.setEsId(estado);
			repoHabitacion.save(ha);
            	if (rsrv == null) {
	                log.warn("no se ha podido reservar");
	                return null;
            		}			
            	return rsrv;
		} catch (Exception e) {
		e.printStackTrace();
		log.error("posible causa: " + e.getCause());
		return null;
	}
	}

}
