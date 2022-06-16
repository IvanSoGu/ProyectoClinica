package com.softtek.controlador;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.softtek.dto.UsuarioDTO;
import com.softtek.exception.ModeloNotFoundException;
import com.softtek.modelo.Rol;
import com.softtek.modelo.Usuario;
import com.softtek.servicio.IUsuarioServicio;

@RestController
@RequestMapping("/usuarios")
public class UsuarioControlador {
	@Autowired
	private IUsuarioServicio servicio;

	@Autowired
	private ModelMapper mapper;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> listar() throws Exception {
		List<UsuarioDTO> lista = servicio.listar().stream().map(x -> mapper.map(x, UsuarioDTO.class))
				.collect(Collectors.toList());
		return new ResponseEntity<>(lista, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsuarioDTO> listarPorId(@PathVariable("id") Integer id) throws Exception {
		Usuario objeto = servicio.listarPorId(id);
		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		UsuarioDTO dtoResponse = mapper.map(objeto, UsuarioDTO.class);
		return new ResponseEntity<>(dtoResponse, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Void> registrar(@Valid @RequestBody UsuarioDTO a) throws Exception {
		List<Rol> roles = new ArrayList<Rol>();
		Rol r = new Rol(2, "Usuario", "USER");
		roles.add(r);
		a.setRoles(roles);
		// Encriptar contraseña
		String password = passwordEncoder.encode(a.getPassword());
		a.setPassword(password);
		Usuario objeto = mapper.map(a, Usuario.class);

		Usuario obj = servicio.registrar(objeto);
		UsuarioDTO dtoResponse = mapper.map(obj, UsuarioDTO.class);

		// Bloque de localizacion formar una url localhost:8080/pacientes/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dtoResponse.getIdUsuario()).toUri();
		return ResponseEntity.created(location).build();
	}

	@PutMapping
	public ResponseEntity<UsuarioDTO> modificar(@Valid @RequestBody UsuarioDTO a) throws Exception {
		Usuario analiticaRequest = mapper.map(a, Usuario.class);
		Usuario analiticaConsultado = servicio.listarPorId(analiticaRequest.getIdUsuario());
		if (analiticaConsultado == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + analiticaRequest.getIdUsuario());
		}
		Usuario BBDD = servicio.modificar(analiticaRequest);
		UsuarioDTO analiticaResponse = mapper.map(BBDD, UsuarioDTO.class);
		return new ResponseEntity<>(analiticaResponse, HttpStatus.OK);
	}

	@DeleteMapping("{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id) throws Exception {
		Usuario objeto = servicio.listarPorId(id);
		if (objeto == null) {
			throw new ModeloNotFoundException("ID NO ENCONTRADO " + id);
		}
		servicio.eliminar(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}