package com.softtek.controlador;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.ConsultaDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Consulta;
import com.softtek.servicio.IConsultaServicio;

@RestController
@RequestMapping("/consultas")
@CrossOrigin(origins="http://localhost:4200")
public class ConsultaControlador {

	@Autowired
	private IConsultaServicio servicio;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<ConsultaDTO>> listar() throws Exception{
		List<ConsultaDTO> lista = servicio.listar().stream().map(x->mapper.map(x, ConsultaDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ConsultaDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Consulta consulta = servicio.listarPorId(id);
		if(consulta == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		ConsultaDTO dtoResponse = mapper.map(consulta, ConsultaDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<ConsultaDTO> registrar(@RequestBody ConsultaDTO c) throws Exception{
		Consulta objeto = mapper.map(c, Consulta.class);
		ConsultaDTO dtoResponse = mapper.map(servicio.registrar(objeto), ConsultaDTO.class);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdConsulta()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<ConsultaDTO> modificar(@RequestBody ConsultaDTO c) throws Exception{
		Consulta consultaRequest = mapper.map(c, Consulta.class);
		Consulta consultaConsultado = servicio.listarPorId(consultaRequest.getIdConsulta());
		if(consultaConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+consultaRequest.getIdConsulta());
		}
		return new ResponseEntity<>(mapper.map(servicio.modificar(consultaRequest), ConsultaDTO.class), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Consulta objeto = servicio.listarPorId(id);
		if(objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
