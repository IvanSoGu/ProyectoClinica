package com.softtek.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pacientes")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPaciente;

	@Column(name = "nombres", nullable = false, length = 70)
	private String nombres;

	@Column(name = "apellidos", nullable = false, length = 70)
	private String apellidos;

	@Column(name = "dni", nullable = false, length = 9)
	private String dni;

	@Column(name = "direccion", nullable = false, length = 150)
	private String direccion;

	@Column(name = "telefono", nullable = false, length = 9)
	private String telefono;

	@Column(name = "email", nullable = false, length = 55)
	private String email;

	public Paciente() {
// TODO Auto-generated constructor stub
	}

	public Paciente(Integer idPaciente, String nombres, String apellidos, String dni, String direccion, String telefono,
			String email) {
		super();
		this.idPaciente = idPaciente;
		this.nombres = nombres;
		this.apellidos = apellidos;
		this.dni = dni;
		this.direccion = direccion;
		this.telefono = telefono;
		this.email = email;
	}

	public Integer getIdPaciente() {
		return idPaciente;
	}

	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Paciente [idPaciente=" + idPaciente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni="
				+ dni + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}

}
