package org.acme.dto.consulta;

import java.util.Map;

public class ConsultaDTO {
    private Map<String, String> parametros;
    private OrdenDTO orden;
    private PaginacionDTO paginacion;
    private RangoDTO rango;

    public ConsultaDTO() {
    }

    public ConsultaDTO(Map<String, String> parametros, OrdenDTO orden, PaginacionDTO paginacion, RangoDTO rango) {
        this.parametros = parametros;
        this.orden = orden;
        this.paginacion = paginacion;
        this.rango = rango;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }

    public OrdenDTO getOrden() {
        return orden;
    }

    public void setOrden(OrdenDTO orden) {
        this.orden = orden;
    }

    public RangoDTO getRango() {
        return rango;
    }

    public void setRango(RangoDTO rango) {
        this.rango = rango;
    }

    public PaginacionDTO getPaginacion() {
        return paginacion;
    }

    public void setPaginacion(PaginacionDTO paginacion) {
        this.paginacion = paginacion;
    }
}
