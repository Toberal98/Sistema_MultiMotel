package com.sistemaMotelario.core.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sistemaMotelario.core.dao.MotelDao;
import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.service.MotelService;

@Service
public class MotelServiceImpl implements MotelService{
    public static Logger log = LoggerFactory.getLogger(DepartamentoServiceImpl.class);
    @Autowired
    private MotelDao motelDao;
	@Override
	public List<SmMotel> findAll() {
		try {
            log.info("Extrayendo moteles desde la base de datos");
            List<SmMotel> m =  motelDao.findAll();
            if (m == null) {
                    log.warn("departamentos no fueron encontrados");
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
            List<SmMotel> m = motelDao.findByMunIdandCatId(idmunicipio, idcategoria,nombre);
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
            log.info("Extrayendo moteles  filtrados por id  desde la base de datos");
            SmMotel m =  motelDao.findByMoId(moId);
            if (m == null) {
                    log.warn("Moteles filtrados id no fueron encontrados");
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
	public List<SmFotos> findHabitacion(int moId) {
		try {
            log.info("Extrayendo las habitaciones en base al motel seleccionado");
            List<SmFotos> m =  motelDao.findHabitacion(moId);
            if (m == null) {
                    log.warn("no es posible encontrar habitaciones para este motel");
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
	public SmHabitacion findById(int idHabitacion) {
		try {
            log.info("Extrayendo la habitacion ");
            SmHabitacion ha =  motelDao.findById(idHabitacion);
            if (ha == null) {
                    log.warn("no es posible encontrar habitaciones");
                    return null;
            }
            return ha;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}
	
}
