/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sistemaMotelario.core.dao.impl;

import com.sistemaMotelario.core.dao.DepartamentoDao;
import com.sistemaMotelario.core.entity.SmDepartamento;
import com.sistemaMotelario.core.repository.DepartamentoRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author Dell
 */
@Component
public class DepartamentoDaoImpl implements DepartamentoDao{
    public static Logger log = LoggerFactory.getLogger(DepartamentoDaoImpl.class);
    @Autowired
    private DepartamentoRepository deparr;
    
    @Override
    public List<SmDepartamento> findAll() {
        try {
            log.info("Extrayendo departamentos desde la base de datos");
            List<SmDepartamento> dep = deparr.findAll();
            if (dep == null) {
                    log.warn("departamentos no fueron encontrados");
                    return null;
            }
            return dep;
        } catch (Exception e) {
                e.printStackTrace();
                log.error(", posible causa: " + e.getCause());
                return null;
        }
    }
    
}
