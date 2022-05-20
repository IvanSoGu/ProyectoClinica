package com.softtek.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class MedicoDTO {

	private Integer idMedico;
	
	@NotNull
	@Size(max=150)
	private String apellidos;
	
	@NotNull
	@Size(min = 12, max=12)
	private String cedula;
	
	@Size(max=255)
	private String fotoUrl;
	
	@NotNull
	@Size(max=70)
	private String nombres;

	public Integer getIdMedico() {
		return idMedico;
	}

	public void setIdMedico(Integer idMedico) {
		this.idMedico = idMedico;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFotoUrl() {
		return fotoUrl;
	}

	public void setFotoUrl(String fotoUrl) {
		this.fotoUrl = fotoUrl;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public MedicoDTO() {
		super();
	}

	@Override
	public String toString() {
		return "MedicoDTO [idMedico=" + idMedico + ", apellidos=" + apellidos + ", cedula=" + cedula + ", fotoUrl="
				+ fotoUrl + ", nombres=" + nombres + "]";
	}
	
	
}
