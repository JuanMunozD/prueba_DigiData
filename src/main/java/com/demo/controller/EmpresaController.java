/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.controller;

import com.demo.exceptions.EmpresaNotFoundException;
import com.demo.entities.Empresa;
import com.demo.repository.EmpresaRepository;
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
@RequestMapping("/api-empresa")
public class EmpresaController {

    @Autowired
    EmpresaRepository empresaRepository;

// Get All Empresa
    @GetMapping("/empresas")
    public List<Empresa> getAllNotes() {
        return empresaRepository.findAll();
    }

// Create a new Empresa
    @PostMapping("/empresas")
    public Empresa createNote(@Valid @RequestBody Empresa empresa) {
        empresa.setId(0); //si es int ponerlo 0 
        return empresaRepository.save(empresa);
    }

// Get a Single Empresa
    @GetMapping("/empresas/{id}")
    public Empresa getNoteById(@PathVariable(value = "id") Integer empresaId) throws EmpresaNotFoundException {
        return empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException(empresaId));
    }

// Update a Empresa
    @PutMapping("/empresas/{id}")
    public Empresa updateNote(@PathVariable(value = "id") Integer empresaId,
            @Valid @RequestBody Empresa empresaDetails) throws EmpresaNotFoundException {

        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException(empresaId));

        empresa.setNombre(empresaDetails.getNombre());
        empresa.setDireccion(empresaDetails.getDireccion());
        empresa.setCiudadDondeEjerce(empresaDetails.getCiudadDondeEjerce());

        Empresa updateEmpresa = empresaRepository.save(empresa);

        return updateEmpresa;
    }

// Delete a Empresa
    @DeleteMapping("/empresas/{id}")
    public ResponseEntity<?> deleteCity(@PathVariable(value = "id") Integer empresaId) throws EmpresaNotFoundException {
        Empresa empresa = empresaRepository.findById(empresaId)
                .orElseThrow(() -> new EmpresaNotFoundException(empresaId));

        empresaRepository.delete(empresa);

        return ResponseEntity.ok().build();
    }
}
