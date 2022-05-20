package com.softtek.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class EspecialidadDTO {

	private Integer idEspecialidad;
	
	@NotNull
	@Size(max=50)
	private String descripcion;
	
	@NotNull
	@Size(max=50)
	private String nombre;

	public Integer getIdEspecialidad() {
		return idEspecialidad;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idEspecialidad = idEspecialidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EspecialidadDTO() {
		super();
	}
	
}
