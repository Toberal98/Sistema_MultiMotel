package com.sistemaMotelario.core.dao.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistemaMotelario.core.dao.MotelDao;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.repository.HabitacionRepository;
import com.sistemaMotelario.core.repository.MotelRepository;


@Component
public class MotelDaoImpl implements MotelDao{

    public static Logger log = LoggerFactory.getLogger(MunicipioDaoImpl.class);
    @Autowired
    private MotelRepository motel;
    @Autowired
    private HabitacionRepository hr;
	@Override
	public List<SmMotel> findAll() {
        try {
            log.info("Extrayendo moteles desde la base de datos");
            List<SmMotel> m = (List<SmMotel>) motel.findAll();
            if (m == null) {
                    log.warn("moteles no fueron encontrados");
                    return null;
            }
            return m;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
		
	}
	@Override
	public List<SmMotel> findByMunIdandCatId(int idmunicipio, int idcategoria, String nombre) {
		
		try {
            log.info("Extrayendo moteles  filtrados por municipio y/o categoria desde la base de datos");
            List<SmMotel> m = motel.findByMunIdandCatId(idmunicipio, idcategoria, nombre);
            if (m == null) {
                    log.warn("Moteles filtrados por municipio y/o categoria no fueron encontrados");
                    return null;
            }
            return m;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}
	@Override
	public SmMotel findByMoId(int moId) {
		try {
            log.info("Extrayendo moteles  filtrados por id desde la base de datos");
            SmMotel m =  motel.findByMoId(moId);
            if (m == null) {
                    log.warn("Moteles filtrados por id no fue encontrado");
                    return null;
            }
            return m;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}
	@Override
	public List<SmHabitacion> findHabitacion(int moId) {
		try {
            log.info("Extrayendo habitaciones por motel");
            List<SmHabitacion> m = hr.findHabitaciones(moId);
            if (m == null) {
                    log.warn("habitaciones por motel encontradas");
                    return null;
            }
            return m;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}

}
