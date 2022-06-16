package com.softtek.servicio.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softtek.modelo.Usuario;
import com.softtek.repo.IUsuarioRepo;
import com.softtek.servicio.IUsuarioServicio;

@Service
public class UsuarioServicioImp extends CRUDImp<Usuario, Integer> implements UserDetailsService, IUsuarioServicio {

	@Autowired
	private IUsuarioRepo repo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		Usuario usuario = repo.findOneByUsername(username);

		if (usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}

		List<GrantedAuthority> roles = new ArrayList<>();

		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});

		UserDetails ud = new User(usuario.getUsername(), usuario.getPassword(), usuario.isEnabled(), true, true, true,
				roles);

		return ud;

	}

	@Override
	protected JpaRepository<Usuario, Integer> getRepo() {
		// TODO Auto-generated method stub
		return repo;
	}

//	@Override
//	public String encriptar(Usuario usuario) {
//		byte[] salt = new String(usuario.getPassword()).getBytes();
//		int iterationCount = 40000;
//		int keyLength = 128;
//		String password = usuario.getPassword();
//		SecretKeySpec key = createSecretKey(password.toCharArray(), salt, iterationCount, keyLength);
//
//		String originalPassword = password;
//		System.out.println("Original password: " + originalPassword);
//		String encryptedPassword = encrypt(originalPassword, key);
//		System.out.println("Encrypted password: " + encryptedPassword);
//		String decryptedPassword = decrypt(encryptedPassword, key);
//		System.out.println("Decrypted password: " + decryptedPassword);
//		return null;
//	}

}
