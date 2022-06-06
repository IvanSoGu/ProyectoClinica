package com.softtek.servicio.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.dto.ConsultaResumenDTO;
import com.softtek.modelo.Analitica;
import com.softtek.modelo.Consulta;
import com.softtek.repo.IConsultaAnaliticaRepo;
import com.softtek.repo.IConsultaRepo;
import com.softtek.servicio.IConsultaServicio;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class ConsultaServicioImp extends CRUDImp<Consulta, Integer> implements IConsultaServicio{

	@Autowired
	private IConsultaRepo repo;
	
	@Autowired
    private IConsultaAnaliticaRepo ceRepo;
	
	@Transactional
    @Override
    public Consulta registrarTransaccional(Consulta consulta, List<Analitica> analiticas) throws Exception {

        //Guarda la referencia de la consulta
        consulta.getDetalleConsulta().forEach(det -> det.setConsulta(consulta));
 
        /*
         * for(DetalleConsulta det : consulta.getDetalleConsulta()) {
         * det.setConsulta(consulta); }
         */
 
        repo.save(consulta);
 
        analiticas.forEach(ex -> ceRepo.registrar(consulta.getIdConsulta(), ex.getIdAnalitica()));
 
        return consulta;
    }
	
	@Override
	protected JpaRepository<Consulta, Integer> getRepo() {
		return repo;
	}

	@Override
	public List<ConsultaResumenDTO> consultasDia() {
		List<ConsultaResumenDTO> consultas = new ArrayList<>();
		repo.consultasDia().forEach(x -> {
		ConsultaResumenDTO cr = new ConsultaResumenDTO();
		cr.setCantidad(Integer.parseInt(String.valueOf(x[0])));
		cr.setFecha(String.valueOf(x[1]));
		consultas.add(cr);
		});
		return consultas;
	}
	
	@Override
    public byte[] generarReporte() {
        // TODO Auto-generated method stub
        byte[] data = null;
 
        Map<String, Object> parametros = new HashMap<>();
        parametros.put("txt_titulo", "Resumen Consulta por fecha");
 
        File file;
        try {
            file = new ClassPathResource("/informes/consultas.jasper").getFile();
            JasperPrint print = JasperFillManager.fillReport(file.getPath(), parametros,
                    new JRBeanCollectionDataSource(consultasDia()));
            data = JasperExportManager.exportReportToPdf(print);
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return data;
    }

}
