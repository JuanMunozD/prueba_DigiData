package com.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "ciudad")
public class Ciudad {

    @Id
    @Null
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String pais;
    @NotNull
    private String poblacion;

    public Ciudad() {
        super();
    }

    /**
     * contrustor de clase ciudad
     * 
     * @param id
     * @param nombre
     * @param pais
     * @param poblacion 
     */
    public Ciudad(int id, String nombre, String pais, String poblacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.poblacion = poblacion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPoblacion() {
        return poblacion;
    }

    public void setPoblacion(String poblacion) {
        this.poblacion = poblacion;
    }

    @Override
    public String toString() {
        return "Ciudad{" + "id=" + id + ", nombre=" + nombre + ", pais=" + pais + ", poblacion=" + poblacion + '}';
    }

}
