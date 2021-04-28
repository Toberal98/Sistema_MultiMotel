/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.dao.impl;

import com.sistemaMotelario.core.dao.MunicipioDao;
import static com.sistemaMotelario.core.dao.impl.DepartamentoDaoImpl.log;
import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.repository.DepartamentoRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.sistemaMotelario.core.repository.MunicipiosRepository;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dell
 */
@Component
public class MunicipioDaoImpl implements MunicipioDao{

    public static Logger log = LoggerFactory.getLogger(MunicipioDaoImpl.class);
    @Autowired
    private MunicipiosRepository munrepository;
    @Override
    public List<SmMunicipio> findByIdDepartamento(Integer idDepartamento) {
        try {
            log.info("Extrayendo municipios desde la base de datos");
            List<SmMunicipio> mun = munrepository.findByIdDepartamento(idDepartamento);
            if (mun == null) {
                    log.warn("municipios no fueron encontrados");
                    return null;
            }
            return mun;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
    }
    
}
