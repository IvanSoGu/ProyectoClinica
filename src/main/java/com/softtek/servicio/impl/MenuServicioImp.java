package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Menu;
import com.softtek.repo.IMenuRepo;

@Service
public class MenuServicioImp extends CRUDImp<Menu, Integer>{

	@Autowired
	private IMenuRepo repo;
	
	@Override
	protected JpaRepository<Menu, Integer> getRepo() {
		return repo;
	}

}
