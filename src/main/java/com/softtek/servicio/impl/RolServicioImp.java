package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Rol;
import com.softtek.repo.IRolRepo;

@Service
public class RolServicioImp extends CRUDImp<Rol, Integer>{

	@Autowired
	private IRolRepo repo;
	
	@Override
	protected JpaRepository<Rol, Integer> getRepo() {
		return repo;
	}

}
