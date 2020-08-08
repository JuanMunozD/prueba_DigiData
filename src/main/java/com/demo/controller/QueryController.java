package com.demo.controller;

import com.demo.exceptions.QueryNotFoundException;
import com.demo.entities.Query;
import com.demo.repository.QueryRepository;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Juan Sebastian
 */
@CrossOrigin //habilitar CORS navegadores
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
    @PostMapping("/queries-ciudades")
    public String createQuerieCiudad(@RequestParam(name = "nName") String nombreCiudad, @RequestParam(name = "paName") String nombrePais, @RequestParam(name = "poName" ) String totalPoblacion, HttpServletResponse httpResponse) throws IOException {
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Ciudad");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO CIUDAD(Nombre,Pais,Poblacion) VALUES ("+ nombreCiudad +","+ nombrePais +","+ totalPoblacion+ ")" );
        query.setEstado(estado);
        query.setFecha(date);
        query.setOpciones(null);
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);        
        // salvar en base de datos
        queryRepository.save(query);        
        httpResponse.sendRedirect("/solicitudes.html");        
        return "<h1>success: </h1>";
    }

// Create a new Query of Empresa
    @PostMapping("/queries-empresas")
    public String createQuerieEmpresa(@RequestParam(name = "nName") String nombreEmpresa, @RequestParam(name = "paName") String nombreDireccion, @RequestParam(name = "poName") String ciudadDondeEjerce, HttpServletResponse httpResponse) throws IOException {
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Empresa");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO EMPRESA(Nombre,Direccion,ciudadDondeEjerce) VALUES ("+ nombreEmpresa +","+ nombreDireccion +","+ ciudadDondeEjerce+ ")" );
        query.setEstado(estado);
        query.setOpciones(null);
        query.setFecha(date);        
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);
        // salvar en base de datos
        queryRepository.save(query);
        
        httpResponse.sendRedirect("/solicitudes.html");
        
        return "<h1>success: </h1>";
    }
    
// Create a new Query of Persona
    @PostMapping("/queries-personas")
    public String createQueriePersona(@RequestParam(name = "nName") String nombrePersona, @RequestParam(name = "paName") String nombreapellidos, @RequestParam(name = "poName") String nombreSexo, HttpServletResponse httpResponse) throws IOException {
        Query query = new Query();
        query.setId(0); //si es int ponerlo 0         
        String tipo_de_solicitud = new String("Creacion de Persona");
        String estado = "P";
        Date date = new Date(); 
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy"); 
        System.out.println(formatter.format(date));
        String query2 = new String("INSERT INTO PERSONA(Nombre,Apellidos,Sexo) VALUES ("+ nombrePersona +","+ nombreapellidos +","+ nombreSexo+ ")" );
        query.setEstado(estado);
        query.setOpciones(null);
        query.setFecha(date);        
        query.setTipoDeSolicitud(tipo_de_solicitud);
        query.setQuery(query2);
        // salvar en base de datos
        queryRepository.save(query);
        
        httpResponse.sendRedirect("/solicitudes.html");
        
        return "<h1>success: </h1>";
    }
    
 
    
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
