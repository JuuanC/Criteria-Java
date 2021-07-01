package org.acme.dto.consulta;

public class OrdenDTO {
    private String campo;
    private Boolean esAscendente;

    public OrdenDTO() {
    }

    public OrdenDTO(String campo, Boolean esAscendente) {
        this.campo = campo;
        this.esAscendente = esAscendente;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public Boolean getEsAscendente() {
        return esAscendente;
    }

    public void setEsAscendente(Boolean esAscendente) {
        this.esAscendente = esAscendente;
    }
}
