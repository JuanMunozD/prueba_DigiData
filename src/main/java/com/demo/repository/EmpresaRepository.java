/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.repository;

/**
 *
 * @author Juan Sebastian
 */
import com.demo.entities.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Juan Sebastian
 */
@Repository
public interface EmpresaRepository extends JpaRepository<Empresa,Integer>{
}    