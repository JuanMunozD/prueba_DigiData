/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@RestController
@RequestMapping("/api-ciudades")
public class CiudadController {

    @Autowired
    CiudadRepository ciudadRepository;

// Get All Ciudad
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

// Get a Single Note
    @GetMapping("/ciudades/{id}")
    public Ciudad getNoteById(@PathVariable(value = "id") Integer ciudadId) throws CiudadNotFoundException {
        return ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new CiudadNotFoundException(ciudadId));
    }

// Update a Note
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

// Delete a Note
    @DeleteMapping("/ciudades/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Integer ciudadId) throws CiudadNotFoundException {
        Ciudad ciudad = ciudadRepository.findById(ciudadId)
                .orElseThrow(() -> new CiudadNotFoundException(ciudadId));

        ciudadRepository.delete(ciudad);

        return ResponseEntity.ok().build();
    }
}
