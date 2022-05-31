package com.softtek.servicio.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Paciente;
import com.softtek.repo.IPacienteRepo;
import com.softtek.servicio.IPacienteServicio;

@Service
public class PacienteServicioImp extends CRUDImp<Paciente, Integer> implements IPacienteServicio{

	@Autowired
	private IPacienteRepo repo;
	
	@Override
	protected JpaRepository<Paciente, Integer> getRepo(){
		return repo;
	}

}
