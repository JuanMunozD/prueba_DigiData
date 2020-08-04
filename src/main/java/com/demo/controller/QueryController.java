/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.exceptions.QueryNotFoundException;
import com.demo.entities.Query;
import com.demo.repository.QueryRepository;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Juan Sebastian
 */
@RestController
@RequestMapping("/api-query")
public class QueryController {

    @Autowired
    QueryRepository queryRepository;

// Get All Query
    @GetMapping("/queries")
    public List<Query> getAllQueries() {
        return queryRepository.findAll();
    }

// Create a new Query of Ciry
    @PostMapping("/queries")
    public Query createQuerie(@RequestParam(name = "nName") String nombreCiudad, @RequestParam(name = "paName") String nombrePais, @RequestParam(name = "poName") String totalPoblacion) {
        System.out.println(nombreCiudad);
        System.out.println(nombrePais);
        System.out.println(totalPoblacion);
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Ciudad");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO CIUDAD(Nombre,Pais,Poblacio) VALUES ("+ nombreCiudad +","+ nombrePais +","+ totalPoblacion+ ")" );
        query.setEstado(estado);
        query.setOpciones("Buscar");
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);
        return queryRepository.save(query);
    }

/** Create a new Query of Empresa
    @PostMapping("/queries-empresas")
    public Query createQuerieEmpresa(@RequestParam(name = "nName") String nombreEmpresa, @RequestParam(name = "paName") String nombreDireccion, @RequestParam(name = "poName") String ciudadDondeEjerce) {
        System.out.println(nombreEmpresa);
        System.out.println(nombreDireccion);
        System.out.println(ciudadDondeEjerce);
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Empresa");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO Empresa(Nombre,Pais,Poblacio) VALUES ("+ nombreEmpresa +","+ nombreDireccion +","+ ciudadDondeEjerce+ ")" );
        query.setEstado(estado);
        query.setOpciones("Buscar");
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);
        return queryRepository.save(query);
    }
    
// Create a new Query of Persona
    @PostMapping("/queries-personas")
    public Query createQueriePersona(@RequestParam(name = "nName") String nombrePersona, @RequestParam(name = "paName") String nombreapellidos, @RequestParam(name = "poName") String nombreSexo) {
        System.out.println(nombrePersona);
        System.out.println(nombreapellidos);
        System.out.println(nombreSexo);
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Persona");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO PERSONA(Nombre,Pais,Poblacio) VALUES ("+ nombrePersona +","+ nombreapellidos +","+ nombreSexo+ ")" );
        query.setEstado(estado);
        query.setOpciones("Buscar");
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);
        return queryRepository.save(query);
    }
    
    */
    
// Get a Single Note
    @GetMapping("/queries/{id}")
    public Query getQuerieById(@PathVariable(value = "id") Integer queryId) throws QueryNotFoundException {
        return queryRepository.findById(queryId)
                .orElseThrow(() -> new QueryNotFoundException(queryId));
    }

// Update a Note
    @PutMapping("/queries/{id}")
    public Query updateQuerie(@PathVariable(value = "id") Integer queryId,
            @Valid @RequestBody Query queryDetails) throws QueryNotFoundException {

        Query query = queryRepository.findById(queryId)
                .orElseThrow(() -> new QueryNotFoundException(queryId));

        query.setEstado(queryDetails.getEstado());
        Query updateQuery = queryRepository.save(query);

        return updateQuery;
    }

// Delete a Note
    @DeleteMapping("/queries/{id}")
    public ResponseEntity<?> deleteQuerie(@PathVariable(value = "id") Integer queryId) throws QueryNotFoundException {
        Query query = queryRepository.findById(queryId)
                .orElseThrow(() -> new QueryNotFoundException(queryId));

        queryRepository.delete(query);

        return ResponseEntity.ok().build();
    }
}
