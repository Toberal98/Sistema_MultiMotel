package com.sistemaMotelario.core.dao.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sistemaMotelario.core.dao.MotelDao;
import com.sistemaMotelario.core.entity.SmFotos;
import com.sistemaMotelario.core.entity.SmHabitacion;
import com.sistemaMotelario.core.entity.SmMotel;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.entity.SmValoracion;
import com.sistemaMotelario.core.repository.FotoRepository;
import com.sistemaMotelario.core.repository.HabitacionRepository;
import com.sistemaMotelario.core.repository.MotelRepository;
import com.sistemaMotelario.core.repository.ValoracionRepository;


@Component
public class MotelDaoImpl implements MotelDao{

    public static Logger log = LoggerFactory.getLogger(MunicipioDaoImpl.class);
    @Autowired
    private MotelRepository motel;
    @Autowired
    private HabitacionRepository hr;
    @Autowired
    private FotoRepository f;
    @Autowired
    private ValoracionRepository vr;
	@Override
	public List<SmMotel> findAll() {
        try {
            log.info("Extrayendo moteles desde la base de datos");
            List<SmMotel> m = (List<SmMotel>) motel.findAll();
            List<SmValoracion> v = vr.findAll();
            for (SmMotel SmMotel : m) {
            	double promedio = 0.0;
            	double suma = 0.0;
				List<SmValoracion> ls = v.stream().filter(sv -> sv.getMoId().getMoId() == SmMotel.getMoId()).collect(Collectors.toList());
				for (SmValoracion smValoracion : ls) {
					
					suma += smValoracion.getValValoracion();
					
				}
				promedio = suma / 5;
				SmMotel.setRating(promedio);
			}
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
			            List<SmValoracion> v = vr.findAll();

			    for (SmMotel SmMotel : m) {
            	double promedio = 0.0;
            	double suma = 0.0;
				List<SmValoracion> ls = v.stream().filter(sv -> sv.getMoId().getMoId() == SmMotel.getMoId()).collect(Collectors.toList());
				for (SmValoracion smValoracion : ls) {
					
					suma += smValoracion.getValValoracion();
					
				}
				promedio = suma / 5;
				SmMotel.setRating(promedio);
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
			
            List<SmValoracion> v = vr.findAll();
            	double promedio = 0.0;
            	double suma = 0.0;
				List<SmValoracion> ls = v.stream().filter(sv -> sv.getMoId().getMoId() == m.getMoId()).collect(Collectors.toList());
				for (SmValoracion smValoracion : ls) {
					
					suma += smValoracion.getValValoracion();
					
				}
				promedio = suma / 5;
				m.setRating(promedio);
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
            List<SmHabitacion> m = hr.findByMoId(moId);
			for (SmHabitacion smHabitacion : m) {
				 List<SmFotos> listaNueva = smHabitacion.getSmFotosList().stream().filter(f -> f.getFhDescripcion().equalsIgnoreCase("Portada")).collect(Collectors.toList());
				 smHabitacion.setSmFotosList(listaNueva);
			}
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
	@Override
	public SmHabitacion findById(int idHabitacion) {
		try {
            log.info("Extrayendo habitacion");
            SmHabitacion habitacion = hr.findById(idHabitacion);
            if (habitacion == null) {
                    log.warn("habitaciones por motel encontradas");
                    return null;
            }
            return habitacion;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
	}

}
