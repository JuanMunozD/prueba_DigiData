/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "empresa")
public class Empresa {

    @Id
    @Null
    private Integer id;
    @NotNull
    private String nombre;
    @NotNull
    private String Direccion;
    @NotNull
    private String CiudadDondeEjerce;

    public Empresa() {
        super();
    }

    public Empresa(Integer id, String nombre, String Direccion, String CiudadDondeEjerce) {
        this.id = id;
        this.nombre = nombre;
        this.Direccion = Direccion;
        this.CiudadDondeEjerce = CiudadDondeEjerce;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCiudadDondeEjerce() {
        return CiudadDondeEjerce;
    }

    public void setCiudadDondeEjerce(String CiudadDondeEjerce) {
        this.CiudadDondeEjerce = CiudadDondeEjerce;
    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + id + ", nombre=" + nombre + ", Direccion=" + Direccion + ", CiudadDondeEjerce=" + CiudadDondeEjerce + '}';
    }
    
    
    
}