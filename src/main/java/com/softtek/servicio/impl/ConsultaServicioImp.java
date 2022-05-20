package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Consulta;
import com.softtek.repo.IConsultaRepo;
import com.softtek.servicio.IConsultaServicio;

@Service
public class ConsultaServicioImp extends CRUDImp<Consulta, Integer> implements IConsultaServicio{

	@Autowired
	private IConsultaRepo repo;
	
	@Override
	protected JpaRepository<Consulta, Integer> getRepo() {
		return repo;
	}

}
