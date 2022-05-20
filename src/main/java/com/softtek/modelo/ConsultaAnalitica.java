package com.softtek.modelo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "Consulta_Analitica")
@IdClass(ConsultaAnaliticaPK.class)
public class ConsultaAnalitica {

    @Id
	private Consulta consulta;
    
    @Id
    private Analitica analitica;

	public ConsultaAnalitica() {
		super();
	}

	public ConsultaAnalitica(Consulta consulta, Analitica analitica) {
		super();
		this.consulta = consulta;
		this.analitica = analitica;
	}

	public Consulta getConsulta() {
		return consulta;
	}

	public void setConsulta(Consulta consulta) {
		this.consulta = consulta;
	}

	public Analitica getAnalitica() {
		return analitica;
	}

	public void setAnalitica(Analitica analitica) {
		this.analitica = analitica;
	}

	@Override
	public String toString() {
		return "ConsultaAnalitica [consulta=" + consulta + ", analitica=" + analitica + "]";
	}
    
    
    
}
