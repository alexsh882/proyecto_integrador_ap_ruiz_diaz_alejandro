/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Interface;

import com.argentinaprogramaanrd.anrd.Entity.Persona;
import java.util.List;


/**
 *
 * @author operador
 */
public interface IPersonaService {
    //index
    public List<Persona> index();
    
    //show
    public Persona show(Long id);
    
    //save
    public void save(Persona persona);
    
    //delete
    public void delete(Long id);
}
