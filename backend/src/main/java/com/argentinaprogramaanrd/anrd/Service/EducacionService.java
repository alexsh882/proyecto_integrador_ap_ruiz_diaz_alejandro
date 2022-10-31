/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Service;

import com.argentinaprogramaanrd.anrd.Entity.Educacion;
import com.argentinaprogramaanrd.anrd.Repository.EducacionRepository;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Alejandro
 */
@Service
@Transactional
public class EducacionService {

    @Autowired
    EducacionRepository educacionRepository;
    
    public List<Educacion> index() {
        return educacionRepository.findAll();
    }
    
    public Optional<Educacion> show(int id) {
        return educacionRepository.findById(id);
    }
    
    public Optional<Educacion> getByName(String name) {
        return educacionRepository.findByName(name);
    }
    
    public void save(Educacion educacion) {
        educacionRepository.save(educacion);
    }
    
    public void delete(int id) {
        educacionRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return educacionRepository.existsById(id);
    }
    
    public boolean existsByName(String name){
        return educacionRepository.existsByName(name);
    }
}
