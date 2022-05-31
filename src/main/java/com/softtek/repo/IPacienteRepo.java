package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.modelo.Paciente;

public interface IPacienteRepo extends JpaRepository<Paciente, Integer> {

}
