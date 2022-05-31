package com.softtek.controlador;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.dto.MenuDTO;
import com.softtek.modelo.Menu;
import com.softtek.servicio.IMenuServicio;

@RestController
@RequestMapping("/menus")
//@CrossOrigin(origins="http://localhost:4200")
public class MenuControllador {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private IMenuServicio servicio;

	@GetMapping
	public ResponseEntity<List<MenuDTO>> listar() throws Exception{
		List<Menu> menus = new ArrayList<Menu>();
		menus = servicio.listar();
		List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
		return new ResponseEntity<>(menusDTO, HttpStatus.OK);
	}
	
	@PostMapping("/usuario")
	public ResponseEntity<List<MenuDTO>> listar(@RequestBody String nombre) throws Exception{
		List<Menu> menus = new ArrayList<>();
		menus = servicio.listarMenuPorUsuario(nombre);
		List<MenuDTO> menusDTO = modelMapper.map(menus, new TypeToken<List<MenuDTO>>() {}.getType());
		return new ResponseEntity<>(menusDTO, HttpStatus.OK);
	}

}
