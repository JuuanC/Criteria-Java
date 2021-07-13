package org.acme.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "proveedor", schema = "test")
public class Proveedor {



    @Column(name = "nombre", length = 50)
    @Pattern(message = "Error: el Nombre no puede tener números o caracteres especiales", regexp = "^[a-zA-Z]*$")
    private String nombre;

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_proveedor")
    private int idProveedor;

    @Pattern(message = "Error: el APELLIDO no puede tener números o caracteres especiales", regexp = "^[a-zA-Z]*$")
    @Column(name = "apellido_paterno", length = 100)
    private String apellidoPaterno;

    @Pattern(message = "Error: el Nombre no puede tener números o caracteres especiales", regexp = "^[a-zA-Z]*$")
    @Column(name = "apellido_materno", length = 100)
    private String apellidoMaterno;

    @Column(name = "es_baja_logica")
    private boolean esBajaLogica;

    @OneToMany(mappedBy = "proveedor", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Telefono> telefonos;

    public Proveedor() {
    }

    public Proveedor(int idProveedor, String nombre, String apellidoPaterno, String apellidoMaterno, boolean esBajaLogica, List<Telefono> telefonos) {
        this.idProveedor = idProveedor;
        this.nombre = nombre;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.esBajaLogica = esBajaLogica;
        this.telefonos = telefonos;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public boolean isEsBajaLogica() {
        return esBajaLogica;
    }

    public void setEsBajaLogica(boolean esBajaLogica) {
        this.esBajaLogica = esBajaLogica;
    }

    public static List<Proveedor> withoutTelefonos(List<Proveedor> proveedores){
        List<Proveedor> resultado = new ArrayList<>();

        proveedores.forEach(item -> {
            Proveedor proveedor = new Proveedor();
            proveedor.setIdProveedor(item.idProveedor);
            proveedor.setNombre(item.nombre);
            proveedor.setApellidoPaterno(item.apellidoPaterno);
            proveedor.setApellidoMaterno(item.apellidoMaterno);
            resultado.add(proveedor);
        });

        return resultado;
    }
}