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

import com.softtek.modelo.Medico;
import com.softtek.servicio.IMedicoServicio;

@RestController
@RequestMapping("/medicos")
public class MedicoControlador {

	@Autowired
	private IMedicoServicio servicio; //
	
	@GetMapping
	public ResponseEntity<List<Medico>> listar() throws Exception{
		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Medico> listarPorId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Medico> registrar(@RequestBody Medico m) throws Exception{
		return new ResponseEntity<>(servicio.registrar(m), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Medico> modificar(@RequestBody Medico m) throws Exception{
		return new ResponseEntity<>(servicio.modificar(m), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
