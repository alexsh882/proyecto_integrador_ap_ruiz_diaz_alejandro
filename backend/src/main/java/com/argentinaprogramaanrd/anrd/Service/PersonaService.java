/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Service;

import com.argentinaprogramaanrd.anrd.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.argentinaprogramaanrd.anrd.Repository.PersonaRepository;
import java.util.Optional;

/**
 *
 * @author operador
 */
@Service
public class PersonaService {

    @Autowired
    PersonaRepository personaRepository;

   
    public List<Persona> index() {
        return personaRepository.findAll();
    }

        
    public Optional<Persona> show(int id) {
        return personaRepository.findById(id);
    }

    
    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    
    public void delete(int id) {
        personaRepository.deleteById(id);

    }
    
    public boolean existsById(int id){
        return personaRepository.existsById(id);                
    }

}
