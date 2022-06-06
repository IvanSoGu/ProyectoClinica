package com.softtek.dto;

import java.util.List;

import javax.validation.constraints.NotNull;

public class ConsultaListaAnaliticaDTO {

	@NotNull
    private ConsultaDTO consulta;
 
    @NotNull
    private List<AnaliticaDTO> lstAnalitica;
 
    public ConsultaDTO getConsulta() {
        return consulta;
    }
 
    public void setConsulta(ConsultaDTO consulta) {
        this.consulta = consulta;
    }
 
    public List<AnaliticaDTO> getLstAnalitica() {
        return lstAnalitica;
    }
 
    public void setLstAnalitica(List<AnaliticaDTO> lstAnalitica) {
        this.lstAnalitica = lstAnalitica;
    }
 
    @Override
    public String toString() {
        return "ConsultaListaAnaliticaDTO [consulta=" + consulta + ", lstExamen=" + lstAnalitica + "]";
    }
}
