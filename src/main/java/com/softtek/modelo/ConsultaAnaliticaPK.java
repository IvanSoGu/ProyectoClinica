 package com.softtek.modelo;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class ConsultaAnaliticaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn( name = "id_consulta", nullable = false)
	private Consulta consulta;
	
	@ManyToOne
	@JoinColumn( name = "id_analitica", nullable = false)
	private Analitica analitica;

	public ConsultaAnaliticaPK() {
		super();
	}

	public ConsultaAnaliticaPK(Consulta consulta, Analitica analitica) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ConsultaAnaliticaPK [consulta=" + consulta + ", analitica=" + analitica + "]";
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(consulta, analitica);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this==o)
			return true;
		if (o==null)
			return false;
		if(getClass() != o.getClass())
			return false;
		ConsultaAnaliticaPK other = (ConsultaAnaliticaPK)o;
		return Objects.equals(consulta, other.consulta) && Objects.equals(analitica,  other.analitica);
	}
	
}
