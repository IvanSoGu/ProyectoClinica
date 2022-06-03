package com.softtek.dto;

import javax.validation.constraints.NotNull;

public class ConsultaDTO {

    @NotNull
    private String fecha;
    @NotNull
    private Integer cantidad;

    public ConsultaDTO(@NotNull @NotNull String fecha, @NotNull Integer cantidad) {
        super();
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public ConsultaDTO() {
        // TODO Auto-generated constructor stub
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "ConsultaDTO [fecha=" + fecha + ", cantidad=" + cantidad + "]";
    }

}
