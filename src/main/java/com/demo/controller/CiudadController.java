package com.demo.controller;

import com.demo.exceptions.CiudadNotFoundException;
import com.demo.entities.Ciudad;
import com.demo.repository.CiudadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import javax.validation.Valid;
import java.util.List;

/**
 *
 * @author Juan Sebastian
 */
@CrossOrigin //habilitar CORS navegadores
@RestController
@RequestMapping("/api-ciudades")
public class CiudadController {

    @Autowired
    CiudadRepository ciudadRepository;

    /**
     * Get all ciudades
     * 
     * @return 
     */
    @GetMapping("/ciudades")
    public List<Ciudad> getAllNotes() {
        return ciudadRepository.findAll();
    }

// Create a new Ciudad
    @PostMapping("/ciudades")
    public Ciudad createNote(@Valid @RequestBody Ciudad ciudad) {
        ciudad.setId(0); //si es int ponerlo 0 
        return ciudadRepository.save(ciudad);
    }

// Get a Single Ciudad
    @GetMapping("/ciudades/{id}")
    public Ciudad getNoteById(@PathVariable(value = "id") Integer ciudadId) throws CiudadNotFoundException {
        return ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new CiudadNotFoundException(ciudadId));
    }

// Update a Ciudad
    @PutMapping("/ciudades/{id}")
    public Ciudad updateNote(@PathVariable(value = "id") Integer ciudadId,
            @Valid @RequestBody Ciudad ciudadDetails) throws CiudadNotFoundException {

        Ciudad ciudad = ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new CiudadNotFoundException(ciudadId));

        ciudad.setNombre(ciudadDetails.getNombre());
        ciudad.setPais(ciudadDetails.getPais());
        ciudad.setPoblacion(ciudadDetails.getPoblacion());

        Ciudad updateCiudad = ciudadRepository.save(ciudad);

        return updateCiudad;
    }

// Delete a Ciudad
    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Integer ciudadId) throws CiudadNotFoundException {
        Ciudad ciudad = ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new CiudadNotFoundException(ciudadId));

        ciudadRepository.delete(ciudad);

        return ResponseEntity.ok().build();
    }
}
