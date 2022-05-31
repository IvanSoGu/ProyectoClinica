package com.softtek.servicio.impl;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImp {

	public boolean tieneAcceso(String path) {
		
		boolean rpta = false;
		
		String metodoRol = "" ;
		
		switch(path) {
		case "listar":
			metodoRol="ADMIN";
			break;
			
		case"listarPorId":
			metodoRol="ADMIN,USER,DBA";
			break;
		}
		
		String metodoRoles[] = metodoRol.split(",");
		
		Authentication usuarioLogueado = SecurityContextHolder.getContext().getAuthentication();
		
		System.out.println(usuarioLogueado.getName());
		
		for (GrantedAuthority auth : usuarioLogueado.getAuthorities()) {
			String rolUser = auth.getAuthority();
			System.out.println(rolUser);
			
			for(String rolMet : metodoRoles) {
				if (rolUser.equalsIgnoreCase(rolMet)) {}
				rpta = true;
			}
			
		}
		
		return rpta;
		
	}
	
}
