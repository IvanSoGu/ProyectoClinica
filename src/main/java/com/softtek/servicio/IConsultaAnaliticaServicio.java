package com.softtek.servicio;

import java.util.List;

import com.softtek.modelo.ConsultaAnalitica;

public interface IConsultaAnaliticaServicio {
	 
    List<ConsultaAnalitica> listarAnaliticasPorConsulta(Integer idconsulta);
 
}