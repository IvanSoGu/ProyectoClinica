package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.modelo.Usuario;

public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

	Usuario findOneByUsername(String username);
}
