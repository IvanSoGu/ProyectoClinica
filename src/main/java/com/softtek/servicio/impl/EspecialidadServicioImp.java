package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Especialidad;
import com.softtek.repo.IEspecialidadRepo;
import com.softtek.servicio.IEspecialidadServicio;

@Service
public class EspecialidadServicioImp extends CRUDImp<Especialidad,Integer> implements IEspecialidadServicio{

	@Autowired
	private IEspecialidadRepo repo;
	
	@Override
	protected JpaRepository<Especialidad, Integer> getRepo() {
		return repo;
	}

}
