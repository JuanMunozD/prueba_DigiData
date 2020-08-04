/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.exceptions.PersonaNotFoundException;
import com.demo.entities.Persona;
import com.demo.repository.PersonaRepository;
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
@RequestMapping("/api-persona")
public class PersonaController {

    @Autowired
    PersonaRepository personaRepository;

// Get All Personas
    @GetMapping("/personas")
    public List<Persona> getAllNotes() {
        return personaRepository.findAll();
    }

// Create a new Persona
    @PostMapping("/personas")
    public Persona createNote(@Valid @RequestBody Persona persona) {
        persona.setCedula(0); //si es int ponerlo 0 
        return personaRepository.save(persona);
    }

// Get a Single Persona
    @GetMapping("/personas/{id}")
    public Persona getNoteById(@PathVariable(value = "id") Integer personaId) throws PersonaNotFoundException {
        return personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));
    }

// Update a Persona
    @PutMapping("/personas/{id}")
    public Persona updateNote(@PathVariable(value = "id") Integer personaId,
            @Valid @RequestBody Persona personaDetails) throws PersonaNotFoundException {

        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        persona.setNombre(personaDetails.getNombre());
        persona.setApellidos(personaDetails.getApellidos());
        persona.setSexo(personaDetails.getSexo());

        Persona updatePersona = personaRepository.save(persona);

        return updatePersona;
    }

// Delete a Persona
    @DeleteMapping("/personas/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Integer personaId) throws PersonaNotFoundException {
        Persona persona = personaRepository.findById(personaId)
                .orElseThrow(() -> new PersonaNotFoundException(personaId));

        personaRepository.delete(persona);

        return ResponseEntity.ok().build();
    }
}
