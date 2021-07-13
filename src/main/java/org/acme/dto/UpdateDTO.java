package org.acme.dto;

import java.util.Map;

public class UpdateDTO {
    private String idCampo;
    private int idValor;
    private Map<String, String> parametros;

    public UpdateDTO() {
    }

    public UpdateDTO(String idCampo, int idValor, Map<String, String> parametros) {
        this.idCampo = idCampo;
        this.idValor = idValor;
        this.parametros = parametros;
    }

    public String getIdCampo() {
        return idCampo;
    }

    public void setIdCampo(String idCampo) {
        this.idCampo = idCampo;
    }

    public int getIdValor() {
        return idValor;
    }

    public void setIdValor(int idValor) {
        this.idValor = idValor;
    }

    public Map<String, String> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, String> parametros) {
        this.parametros = parametros;
    }
}
