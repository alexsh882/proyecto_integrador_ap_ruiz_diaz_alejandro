/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Service;

import com.argentinaprogramaanrd.anrd.Entity.Persona;
import com.argentinaprogramaanrd.anrd.Interface.IPersonaService;
import com.argentinaprogramaanrd.anrd.Repository.IPersonaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author operador
 */
@Service
public class ImpPersonaService implements IPersonaService {

    @Autowired
    IPersonaRepository personaRepository;

    @Override
    public List<Persona> index() {
        List<Persona> personas = personaRepository.findAll();
        return personas;
    }

    @Override
    public Persona show(Long id) {
        Persona persona = personaRepository.findById(id).orElse(null);
        return persona;
    }

    @Override
    public void save(Persona persona) {
        personaRepository.save(persona);
    }

    @Override
    public void delete(Long id) {
        personaRepository.deleteById(id);

    }

}
