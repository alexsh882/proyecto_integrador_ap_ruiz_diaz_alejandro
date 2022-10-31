/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Service;

import com.argentinaprogramaanrd.anrd.Entity.ExperienciaLaboral;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.argentinaprogramaanrd.anrd.Repository.ExperienciaLaboralRepository;

/**
 *
 * @author Alejandro
 */
@Service
@Transactional
public class ExperienciaLaboralService {

    @Autowired
    ExperienciaLaboralRepository iExperienciaLaboralRepository;
    
    public List<ExperienciaLaboral> index() {
        return iExperienciaLaboralRepository.findAll();
    }
    
    public Optional<ExperienciaLaboral> show(int id) {
        return iExperienciaLaboralRepository.findById(id);
    }
    
    public Optional<ExperienciaLaboral> getByName(String name) {
        return iExperienciaLaboralRepository.findByName(name);
    }
    
    public void save(ExperienciaLaboral exp) {
        iExperienciaLaboralRepository.save(exp);
    }
    
    public void delete(int id) {
        iExperienciaLaboralRepository.deleteById(id);
    }
    
    public boolean existsById(int id){
        return iExperienciaLaboralRepository.existsById(id);                
    }
    
    public boolean existsByName(String name){
        return iExperienciaLaboralRepository.existsByName(name);
    }
}
