package com.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @Null
    private Integer cedula;
    @NotNull
    private String Nombre;
    @NotNull
    private String Apellidos;
    @NotNull
    private String Sexo;

    public Persona() {
        super();
    }

    public Persona(Integer cedula, String Nombre, String Apellidos, String Sexo) {
        this.cedula = cedula;
        this.Nombre = Nombre;
        this.Apellidos = Apellidos;
        this.Sexo = Sexo;
    }

    public Integer getCedula() {
        return cedula;
    }

    public void setCedula(Integer cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    @Override
    public String toString() {
        return "Persona{" + "cedula=" + cedula + ", Nombre=" + Nombre + ", Apellidos=" + Apellidos + ", Sexo=" + Sexo + '}';
    }
    
    
}