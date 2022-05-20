package com.softtek.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.modelo.Analitica;
import com.softtek.servicio.IAnaliticaServicio;

@RestController
@RequestMapping("/analiticas")
@CrossOrigin(origins="http://localhost:4200")
public class AnaliticaControlador {

	@Autowired
	private IAnaliticaServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Analitica>> listar() throws Exception{
		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Analitica> listarPorId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Analitica> registrar(@RequestBody Analitica a) throws Exception{
		return new ResponseEntity<>(servicio.registrar(a), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Analitica> modificar(@RequestBody Analitica a) throws Exception{
		return new ResponseEntity<>(servicio.modificar(a), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
