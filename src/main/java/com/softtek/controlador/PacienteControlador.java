package com.softtek.controlador;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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

import com.softtek.dto.PacienteDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Paciente;
import com.softtek.servicio.IPacienteServicio;

@RestController
@RequestMapping("/pacientes")
@CrossOrigin(origins="http://localhost:4200")
public class PacienteControlador {

	@Autowired
	private IPacienteServicio servicio;
	
	@Autowired
	private ModelMapper mapper;
	
	@GetMapping
	public ResponseEntity<List<PacienteDTO>> listar() throws Exception{
		List<PacienteDTO> lista = servicio.listar().stream().map(x->mapper.map(x, PacienteDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<PacienteDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Paciente paciente = servicio.listarPorId(id);
		if( paciente ==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id);
		}
		PacienteDTO dtoResponse = mapper.map(paciente, PacienteDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<PacienteDTO> registrar(@Valid @RequestBody PacienteDTO p) throws Exception{
		Paciente objeto = mapper.map(p, Paciente.class);
		PacienteDTO dtoResponse = mapper.map(servicio.registrar(objeto), PacienteDTO.class);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdPaciente()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<PacienteDTO> modificar(@Valid @RequestBody PacienteDTO p) throws Exception{
		Paciente pacienteRequest = mapper.map(p, Paciente.class);
		Paciente pacienteConsultado = servicio.listarPorId(pacienteRequest.getIdPaciente());
		if(pacienteConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO" + pacienteRequest.getIdPaciente());
		}
		return new ResponseEntity<>(mapper.map(servicio.modificar(pacienteRequest), PacienteDTO.class), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Paciente objeto = servicio.listarPorId(id);
		if(objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+ id); 
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@GetMapping("/hateoas/{id}")
	public EntityModel<PacienteDTO> listarHateoas(@PathVariable("id") Integer id) throws Exception{
		Paciente obj = servicio.listarPorId(id);
		if (obj == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		
		PacienteDTO dto = mapper.map(obj, PacienteDTO.class);
		
		EntityModel<PacienteDTO> recurso = EntityModel.of(dto);
		WebMvcLinkBuilder link1 = linkTo(methodOn(this.getClass()).listarPorId(id));
		
		recurso.add(link1.withRel("paciente-link"));
		return recurso;
	} 
	
}
