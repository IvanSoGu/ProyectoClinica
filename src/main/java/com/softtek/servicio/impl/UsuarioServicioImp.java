package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Usuario;
import com.softtek.repo.IUsuarioRepo;

@Service
public class UsuarioServicioImp extends CRUDImp<Usuario,Integer>{

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	protected JpaRepository<Usuario, Integer> getRepo() {
		return repo;
	}

}
