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

import com.softtek.modelo.Rol;
import com.softtek.servicio.IRolServicio;

@RestController
@RequestMapping("/roles")
@CrossOrigin(origins="http://localhost:4200")
public class RolControlador {

	@Autowired
	private IRolServicio servicio;
	
	@GetMapping
	public ResponseEntity<List<Rol>> listar() throws Exception{
		return new ResponseEntity<>(servicio.listar(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Rol> listarPorId(@PathVariable("id") Integer id) throws Exception {
		return new ResponseEntity<>(servicio.listarPorId(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Rol> registrar(@RequestBody Rol r) throws Exception{
		return new ResponseEntity<>(servicio.registrar(r), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<Rol> modificar(@RequestBody Rol r) throws Exception{
		return new ResponseEntity<>(servicio.modificar(r), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
