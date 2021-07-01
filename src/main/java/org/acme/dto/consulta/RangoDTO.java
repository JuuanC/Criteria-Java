package org.acme.dto.consulta;

public class RangoDTO {
    private String campo;
    private String inicio;
    private String fin;

    public RangoDTO() {
    }

    public RangoDTO(String campo, String inicio, String fin) {
        this.campo = campo;
        this.inicio = inicio;
        this.fin = fin;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getInicio() {
        return inicio;
    }

    public void setInicio(String inicio) {
        this.inicio = inicio;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }
}
