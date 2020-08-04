package com.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.sql.Date;
@Entity
@Table(name = "query")
public class Query {

    @Id
    @Null
    private Integer id;
    @NotNull
    private String tipoDeSolicitud;
    @NotNull
    private Date fecha;
    @NotNull
    private String opciones;
    @NotNull
    private String estado;
    @NotNull
    private String query;

    public Query() {
        super();
    }

    public Query(Integer id, String tipoDeSolicitud, Date fecha, String opciones, String estado, String query) {
        this.id = id;
        this.tipoDeSolicitud = tipoDeSolicitud;
        this.fecha = fecha;
        this.opciones = opciones;
        this.estado = estado;
        this.query = query;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoDeSolicitud() {
        return tipoDeSolicitud;
    }

    public void setTipoDeSolicitud(String tipoDeSolicitud) {
        this.tipoDeSolicitud = tipoDeSolicitud;
    }

    public Date fecha() {
        return fecha;
    }

    public void fecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        return "Query{" + "id=" + id + ", tipoDeSolicitud=" + tipoDeSolicitud + ", fecha=" + fecha + ", opciones=" + opciones + ", estado=" + estado + ", query=" + query + '}';
    }

    

}
