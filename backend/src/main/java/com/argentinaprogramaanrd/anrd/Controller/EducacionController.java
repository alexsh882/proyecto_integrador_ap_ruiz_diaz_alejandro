/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Controller;

import com.argentinaprogramaanrd.anrd.Entity.Educacion;
import com.argentinaprogramaanrd.anrd.Security.Controller.Helpers.Message;
import com.argentinaprogramaanrd.anrd.Service.EducacionService;
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
@CrossOrigin(origins = "http://localhost:4200")
public class EducacionController {

    @Autowired
    EducacionService educacionService;

    @GetMapping("/educacion")
    public ResponseEntity<List<Educacion>> index() {
        List<Educacion> list = educacionService.index();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @PostMapping("/educacion")
    public ResponseEntity<?> store(@RequestBody Educacion educacion) {
        if (StringUtils.isBlank(educacion.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }
        if (StringUtils.isBlank(educacion.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacion.getTimeLapse())) {
            return new ResponseEntity(new Message("El tiempo de cursada es obligatoria."), HttpStatus.BAD_REQUEST);
        }
        if (educacionService.existsByName(educacion.getName())) {
            return new ResponseEntity(new Message("El nombre ya existe."), HttpStatus.BAD_REQUEST);
        }
        educacionService.save(educacion);
        return new ResponseEntity(new Message("Educación creada correctamente."), HttpStatus.OK);
    }

    @PutMapping("/educacion/{id}/update")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Educacion educacion) {

        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Message("No existe la educación que busca"), HttpStatus.NOT_FOUND);
        }

        if (educacionService.existsByName(educacion.getName()) && educacionService.getByName(educacion.getName()).get().getId() != id) {
            return new ResponseEntity(new Message("El nombre ya existe."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacion.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacion.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(educacion.getTimeLapse())) {
            return new ResponseEntity(new Message("El tiempo de cursada es obligatoria."), HttpStatus.BAD_REQUEST);
        }

        Educacion educacion_original = educacionService.show(id).get();

        educacion_original.setName(educacion.getName());
        educacion_original.setTimeLapse(educacion.getTimeLapse());
        educacion_original.setDescription(educacion.getDescription());

        educacionService.save(educacion_original);
        return new ResponseEntity(new Message("Educacion guardada correctamente."), HttpStatus.OK);

    }

    @DeleteMapping("/educacion/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        if (!educacionService.existsById(id)) {
            return new ResponseEntity(new Message("No existe la educación que busca"), HttpStatus.NOT_FOUND);
        }

        educacionService.delete(id);
        return new ResponseEntity(new Message("Educación eliminada correctamente."), HttpStatus.OK);

    }

}
