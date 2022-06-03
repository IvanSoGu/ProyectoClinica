package com.softtek.servicio;

import java.util.List;

import com.softtek.dto.ConsultaDTO;
import com.softtek.modelo.Consulta;

public interface IConsultaServicio extends ICRUD<Consulta, Integer>{

	List<ConsultaDTO> consultasDia();
	
	byte[] generarReporte();

}
