package com.softtek.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PacienteDTO {

	private Integer idPaciente;
	
	@NotNull
	@Size(min=3, message="{apellidos.size}")
	private String nombres;
	
	@NotNull
	@Size(min=4)
	private String apellidos;
	
	@NotNull
	@Size(min= 8)
	private String dni;
	
	@NotNull
	@Size(min=9, max=150)
	private String direccion;
	
	@NotNull
	@Size(min = 9, max=9)
	private String telefono;
	
	@NotNull
	@Email
	private String email;
	
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
	
	public PacienteDTO() {
		super();
	}
	
	@Override
	public String toString() {
		return "PacienteDTO [idPaciente=" + idPaciente + ", nombres=" + nombres + ", apellidos=" + apellidos + ", dni="
				+ dni + ", direccion=" + direccion + ", telefono=" + telefono + ", email=" + email + "]";
	}

}
