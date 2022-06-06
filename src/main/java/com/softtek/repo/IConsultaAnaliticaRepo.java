package com.softtek.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.softtek.modelo.ConsultaAnalitica;

public interface IConsultaAnaliticaRepo extends JpaRepository<ConsultaAnalitica, Integer>{
	 
    //@Transactional
    @Modifying
    @Query(value = "INSERT INTO consulta_analitica(id_consulta, id_analitica) VALUES (:idConsulta, :idAnalitica)", nativeQuery = true)
    Integer registrar(@Param("idConsulta") Integer idConsulta, @Param("idAnalitica") Integer idAnalitica);

    @Query("FROM ConsultaAnalitica ce where ce.consulta.idConsulta = :idConsulta")
    List<ConsultaAnalitica> listarAnaliticasPorConsulta(@Param("idConsulta") Integer idconsulta);
    //[consulta, examen]
    //[consulta, examen]
    //[consulta, examen]
 

}
