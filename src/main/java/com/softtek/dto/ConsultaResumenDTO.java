package com.softtek.dto;

import javax.validation.constraints.NotNull;

public class ConsultaResumenDTO {

    @NotNull
    private String fecha;
    @NotNull
    private Integer cantidad;

    public ConsultaResumenDTO(@NotNull @NotNull String fecha, @NotNull Integer cantidad) {
        super();
        this.fecha = fecha;
        this.cantidad = cantidad;
    }

    public ConsultaResumenDTO() {
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
        return "ConsultaResumenDTO [fecha=" + fecha + ", cantidad=" + cantidad + "]";
    }

}
