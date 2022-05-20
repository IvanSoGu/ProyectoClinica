package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Medicos")
public class Medico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idMedico;
	
	@Column(name ="apellidos", nullable = false, length = 70)
	private String apellidos;
	
	@Column(name ="cedula", nullable = false, length = 12)
	private String cedula;
	
	@Column(name ="fotoUrl", nullable = true, length = 255)
	private String fotoUrl;
	
	@Column(name ="nombres", nullable = false, length = 70)
	private String nombres;

	public Medico() {
		super();
	}

	public Medico(Integer idMedico, String apellidos, String cedula, String fotoUrl, String nombres) {
		super();
		this.idMedico = idMedico;
		this.apellidos = apellidos;
		this.cedula = cedula;
		this.fotoUrl = fotoUrl;
		this.nombres = nombres;
	}

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

	@Override
	public String toString() {
		return "Medico [idMedico=" + idMedico + ", apellidos=" + apellidos + ", cedula=" + cedula + ", fotoUrl="
				+ fotoUrl + ", nombres=" + nombres + "]";
	}
	
}
