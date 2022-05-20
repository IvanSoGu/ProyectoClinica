package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Analiticas")
public class Analitica {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idAnalitica;
	
	@Column(name = "descripcion", nullable = false, length = 50)
	private String descripcion;
	
	@Column(name = "nombre", nullable = false, length = 50)
	private String nombre;

	public Analitica() {
		super();
	}

	public Analitica(Integer idAnalitica, String descripcion, String nombre) {
		super();
		this.idAnalitica = idAnalitica;
		this.descripcion = descripcion;
		this.nombre = nombre;
	}

	public Integer getIdEspecialidad() {
		return idAnalitica;
	}

	public void setIdEspecialidad(Integer idEspecialidad) {
		this.idAnalitica = idEspecialidad;
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
		return "Analitica [idEspecialidad=" + idAnalitica + ", descripcion=" + descripcion + ", nombre=" + nombre
				+ "]";
	}
	
}
