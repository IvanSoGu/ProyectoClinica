package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Analitica;
import com.softtek.repo.IAnaliticaRepo;
import com.softtek.servicio.IAnaliticaServicio;

@Service
public class AnaliticaServicioImp extends CRUDImp<Analitica, Integer> implements IAnaliticaServicio{

	@Autowired
	private IAnaliticaRepo repo;
	
	@Override
	protected JpaRepository<Analitica, Integer> getRepo() {
		return repo;
	}

}
