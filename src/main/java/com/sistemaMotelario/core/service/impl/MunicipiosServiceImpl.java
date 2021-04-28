/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.service.impl;

import com.sistemaMotelario.core.dao.DepartamentoDao;
import com.sistemaMotelario.core.dao.MunicipioDao;
import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.entity.SmMunicipio;
import com.sistemaMotelario.core.service.MunicipiosService;
import static com.sistemaMotelario.core.service.impl.DepartamentoServiceImpl.log;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Dell
 */
@Service
public class MunicipiosServiceImpl implements MunicipiosService{

        public static Logger log = LoggerFactory.getLogger(DepartamentoServiceImpl.class);
    @Autowired
    private MunicipioDao mundao;
    @Override
    public List<SmMunicipio> findByIdDepartamento(Integer idDepartamento) {
        try {
            log.info("Extrayendo departamentos desde la base de datos");
            List<SmMunicipio> m =  mundao.findByIdDepartamento(idDepartamento);
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
    
}
