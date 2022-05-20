package com.softtek.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.softtek.modelo.Especialidad;
import com.softtek.servicio.IEspecialidadServicio;

public class EspecialidadContolador {

	@Autowired
	private IEspecialidadServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Especialidad>> listar() throws Exception{
		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Especialidad> listarPorId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Especialidad> registrar(@RequestBody Especialidad e) throws Exception{
		return new ResponseEntity<>(servicio.registrar(e), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Especialidad> modificar(@RequestBody Especialidad e) throws Exception{
		return new ResponseEntity<>(servicio.modificar(e), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
