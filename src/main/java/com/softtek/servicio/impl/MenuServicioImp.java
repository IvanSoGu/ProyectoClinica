package com.softtek.servicio.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Menu;
import com.softtek.repo.IMenuRepo;
import com.softtek.servicio.IMenuServicio;

@Service
public class MenuServicioImp extends CRUDImp<Menu, Integer> implements IMenuServicio{

	@Autowired
	private IMenuRepo repo;
	
	@Override
	protected JpaRepository<Menu, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<Menu> listarMenuPorUsuario(String nombre) {
		
		return repo.listarMenuPorUsuario(nombre);
	}

}
