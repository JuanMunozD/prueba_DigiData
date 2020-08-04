/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.exceptions;

/**
 *
 * @author Juan Sebastian
 */
public class EmpresaNotFoundException extends Exception {

    private Integer empresa_id;

    public EmpresaNotFoundException(Integer empresa_id) {
        super(String.format("City is not found with id : '%s'", empresa_id));
    }
} 
    

