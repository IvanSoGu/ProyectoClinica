package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.modelo.ConsultaAnalitica;
import com.softtek.repo.IConsultaAnaliticaRepo;
import com.softtek.servicio.IConsultaAnaliticaServicio;

@Service
public class ConsultaAnaliticaServicioImp implements IConsultaAnaliticaServicio{
 
    @Autowired
    private IConsultaAnaliticaRepo repo;

    @Override
    public List<ConsultaAnalitica> listarAnaliticasPorConsulta(Integer idconsulta) {
        return repo.listarAnaliticasPorConsulta(idconsulta);
    }
}
