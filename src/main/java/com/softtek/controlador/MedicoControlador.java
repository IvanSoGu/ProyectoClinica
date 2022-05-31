package com.softtek.controlador;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.MedicoDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Medico;
import com.softtek.servicio.IMedicoServicio;

@RestController
@RequestMapping("/medicos")
//@CrossOrigin(origins="http://localhost:4200")
public class MedicoControlador {

	@Autowired
	private IMedicoServicio servicio;
	
	@Autowired
	private ModelMapper mapper;
	
//	@PreAuthorize("hasAuthority('ADMIN')")
	@PreAuthorize("@authServiceImp.tieneAcceso('listar')")
	@GetMapping
	public ResponseEntity<List<MedicoDTO>> listar() throws Exception{
		List<MedicoDTO> lista = servicio.listar().stream().map(x->mapper.map(x, MedicoDTO.class)).collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MedicoDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Medico medico = servicio.listarPorId(id);
		if( medico == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		MedicoDTO dtoResponse = mapper.map(medico, MedicoDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<MedicoDTO> registrar(@RequestBody MedicoDTO m) throws Exception{
		Medico objeto = mapper.map(m, Medico.class);
		MedicoDTO dtoResponse = mapper.map(servicio.registrar(objeto), MedicoDTO.class);
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dtoResponse.getIdMedico()).toUri();
		return ResponseEntity.created(location).build();
	}
	
	@PutMapping
	public ResponseEntity<MedicoDTO> modificar(@RequestBody MedicoDTO m) throws Exception{
		Medico medicoRequest = mapper.map(m, Medico.class);
		Medico medicoConsultado = servicio.listarPorId(medicoRequest.getIdMedico());
		if(medicoConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+medicoRequest.getIdMedico());
		}
		return new ResponseEntity<>(mapper.map(servicio.modificar(medicoRequest), MedicoDTO.class), HttpStatus.OK);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception{
		Medico objeto = servicio.listarPorId(id);
		if(objeto==null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO "+id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
