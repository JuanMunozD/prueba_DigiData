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
public class QueryNotFoundException extends Exception{
    private Integer query_id;

    public QueryNotFoundException(Integer query_id) {
        super(String.format("City is not found with id : '%s'", query_id));
    }
}
