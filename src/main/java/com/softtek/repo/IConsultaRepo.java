package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.softtek.modelo.Consulta;

public interface IConsultaRepo extends JpaRepository <Consulta, Integer>{

	@Query(value = "select * from TABLA_CONSULTASPORDIA()", nativeQuery = true)
	List<Object[]> consultasDia();
	
}
