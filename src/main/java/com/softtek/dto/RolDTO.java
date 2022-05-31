package com.softtek.dto;

public class RolDTO {

	private Integer idRol;
	private String nombre;
	private String descripcion;

	public Integer getIdRol() {
		return idRol;
	}
	public void setIdRol(Integer idRol) {
		this.idRol = idRol;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public RolDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "RolDTO [idRol=" + idRol + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
}
