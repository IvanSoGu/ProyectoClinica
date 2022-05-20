package com.softtek.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.softtek.modelo.DetalleConsulta;
import com.softtek.modelo.Especialidad;
import com.softtek.modelo.Medico;
import com.softtek.modelo.Paciente;

public class ConsultaDTO {

	private Integer idConsulta;
	
	@NotNull
	private Paciente paciente;
	
	@NotNull
	private Medico medico;
	
	@NotNull
	private Especialidad especialidad;
	
	@NotNull
	@Size(min = 3, max=3)
	private String numConsultorio;
	
	@NotNull
	private LocalDateTime fecha;
	
	@NotNull
	private List<DetalleConsulta> detalleConsulta;

	public Integer getIdConsulta() {
		return idConsulta;
	}

	public void setIdConsulta(Integer idConsulta) {
		this.idConsulta = idConsulta;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Medico getMedico() {
		return medico;
	}

	public void setMedico(Medico medico) {
		this.medico = medico;
	}

	public Especialidad getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(Especialidad especialidad) {
		this.especialidad = especialidad;
	}

	public String getNumConsultorio() {
		return numConsultorio;
	}

	public void setNumConsultorio(String numConsultorio) {
		this.numConsultorio = numConsultorio;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public void setFecha(LocalDateTime fecha) {
		this.fecha = fecha;
	}

	public List<DetalleConsulta> getDetalleConsulta() {
		return detalleConsulta;
	}

	public void setDetalleConsulta(List<DetalleConsulta> detalleConsulta) {
		this.detalleConsulta = detalleConsulta;
	}

	public ConsultaDTO() {
		super();
	}
	
	
}
