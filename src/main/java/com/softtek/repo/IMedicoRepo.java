package com.softtek.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.modelo.Medico;

public interface IMedicoRepo extends JpaRepository <Medico, Integer> {

}
