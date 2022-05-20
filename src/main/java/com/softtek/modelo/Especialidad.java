package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Especialidades")
public class Especialidad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idEspecialidad;
	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Especialidad() {
		super();
	}

	public Especialidad(Integer idEspecialidad, String descripcion, String nombre) {
		super();
		this.idEspecialidad = idEspecialidad;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

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

	@Override
	public String toString() {
		return "Especialidad [idEspecialidad=" + idEspecialidad + ", descripcion=" + descripcion + ", nombre=" + nombre
				+ "]";
	}
	
}
