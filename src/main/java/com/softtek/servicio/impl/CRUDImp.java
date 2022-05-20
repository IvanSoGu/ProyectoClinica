package com.softtek.servicio.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract class CRUDImp<T,ID>{
	

	protected abstract JpaRepository<T, ID> getRepo();

	public T registrar(T t) throws Exception {
		return getRepo().save(t);
	}

	public T modificar(T t) throws Exception {
		return getRepo().save(t);
		
	}

	public List<T> listar() throws Exception {
		return getRepo().findAll();
	}

	public T listarPorId(ID id) throws Exception {

		Optional<T> m1 = (Optional<T>) getRepo().findById(id);
		return m1.isPresent() ? m1.get() : null;
	}

	public void eliminar(ID id) throws Exception {
		getRepo().deleteById(id);
	}

}
