package org.acme.dto.consulta;

public class PaginacionDTO {

    private int inicio;
    private int tamanio;

    public PaginacionDTO() {
    }

    public PaginacionDTO(int inicio, int tamanio) {
        this.inicio = inicio;
        this.tamanio = tamanio;
    }

    public int getInicio() {
        return inicio;
    }

    public void setInicio(int inicio) {
        this.inicio = inicio;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }
}
