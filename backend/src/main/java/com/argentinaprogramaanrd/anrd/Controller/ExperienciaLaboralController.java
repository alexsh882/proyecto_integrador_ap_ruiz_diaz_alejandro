/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Controller;

import com.argentinaprogramaanrd.anrd.Service.ExperienciaLaboralService;
import com.argentinaprogramaanrd.anrd.Entity.ExperienciaLaboral;
import com.argentinaprogramaanrd.anrd.Security.Controller.Helpers.Message;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro
 */
@RestController
//@RequestMapping("experiencia-laboral")
@CrossOrigin(origins = "http://localhost:4200")
public class ExperienciaLaboralController {

    @Autowired
    ExperienciaLaboralService impExperiencia;

    @GetMapping("experiencia-laboral")
    public ResponseEntity<List<ExperienciaLaboral>> index() {
        List<ExperienciaLaboral> list = impExperiencia.index();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @GetMapping("experiencua-laboral/{id}")
    public ResponseEntity<?> show(@PathVariable("id") int id){
        if (!impExperiencia.existsById(id)) {
            return new ResponseEntity(new Message("El id de la experiencia no existe."), HttpStatus.BAD_REQUEST);
        }
        
        return new ResponseEntity(impExperiencia.show(id), HttpStatus.OK);
    }
    

    @PostMapping("experiencia-laboral")
    public ResponseEntity<?> store(@RequestBody ExperienciaLaboral exp) {
        if (StringUtils.isBlank(exp.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(exp.getTimeFor())) {
            return new ResponseEntity(new Message("El tiempo de la experiencia es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(exp.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (impExperiencia.existsByName(exp.getName())) {
            return new ResponseEntity(new Message("La experiencia que estás queriendo ingresar ya existe."), HttpStatus.BAD_REQUEST);
        }
        impExperiencia.save(exp);
        return new ResponseEntity(new Message("Experiencia Agregada Correctamente."), HttpStatus.OK);
    }
    
    @PutMapping("/experiencia-laboral/{id}/update")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody ExperienciaLaboral exp) {

        if (!impExperiencia.existsById(id)) {
            return new ResponseEntity(new Message("El id de la experiencia no existe."), HttpStatus.BAD_REQUEST);
        }
        
        if (impExperiencia.existsByName(exp.getName()) && impExperiencia.getByName(exp.getName()).get().getId() != id) {
            return new ResponseEntity(new Message("La experiencia que queres ingresar ya existe"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(exp.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(exp.getTimeFor())) {
            return new ResponseEntity(new Message("El tiempo de la experiencia es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        
        if (StringUtils.isBlank(exp.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        

        ExperienciaLaboral experiencia = impExperiencia.show(id).get();
        experiencia.setName(exp.getName());
        experiencia.setTitle(exp.getTitle());
        experiencia.setTimeFor(exp.getTimeFor());
        experiencia.setDescription(exp.getDescription());
        impExperiencia.save(experiencia);
        return new ResponseEntity(new Message("Experiencia " + experiencia.getName() + " actualizada correctamente."), HttpStatus.OK);
    }

    @DeleteMapping("/experiencia-laboral/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!impExperiencia.existsById(id)) {
            return new ResponseEntity(new Message("El id de la experiencia no existe."), HttpStatus.BAD_REQUEST);
        }
        impExperiencia.delete(id);
        return new ResponseEntity(new Message("Experiencia eliminada correctamente."), HttpStatus.OK);

    }
}
