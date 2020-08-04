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
public class CiudadNotFoundException extends Exception {

    private Integer ciudad_id;

    public CiudadNotFoundException(Integer ciudad_id) {
        super(String.format("City is not found with id : '%s'", ciudad_id));
    }
}
