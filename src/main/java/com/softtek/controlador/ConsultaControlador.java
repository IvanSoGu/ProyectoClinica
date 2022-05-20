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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.modelo.Consulta;
import com.softtek.servicio.IConsultaServicio;

@RestController
@RequestMapping("/consultas")
public class ConsultaControlador {

	@Autowired
	private IConsultaServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Consulta>> listar() throws Exception{
		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Consulta> listarPorId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Consulta> registrar(@RequestBody Consulta c) throws Exception{
		return new ResponseEntity<>(servicio.registrar(c), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Consulta> modificar(@RequestBody Consulta c) throws Exception{
		return new ResponseEntity<>(servicio.modificar(c), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
