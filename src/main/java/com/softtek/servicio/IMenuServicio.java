package com.softtek.servicio;

import java.util.List;

import com.softtek.modelo.Menu;

public interface IMenuServicio extends ICRUD<Menu, Integer> {

	List<Menu> listarMenuPorUsuario(String nombre);
}
