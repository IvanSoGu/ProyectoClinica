package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Medico;
import com.softtek.repo.IMedicoRepo;
import com.softtek.servicio.IMedicoServicio;

@Service
public class MedicoServicioImp extends CRUDImp<Medico, Integer> implements IMedicoServicio {

	@Autowired
	private IMedicoRepo repo;
	
	@Override
	protected JpaRepository<Medico, Integer> getRepo() {
		return repo;
	}

}
