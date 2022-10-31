/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Controller;

import com.argentinaprogramaanrd.anrd.Entity.Persona;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.argentinaprogramaanrd.anrd.Security.Controller.Helpers.Message;
import com.argentinaprogramaanrd.anrd.Service.PersonaService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author operador
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    PersonaService iPersonaService;

    @GetMapping("personas")
    public ResponseEntity<List<Persona>> index() {
        List<Persona> list = iPersonaService.index();
        return new ResponseEntity(list, HttpStatus.OK);
    }

    @GetMapping("personas/{id}")
    public ResponseEntity<Persona> show(@PathVariable("id") int id) {
        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Message("La persona que buscas no existe."), HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity(iPersonaService.show(id).get(), HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ROLE_ADMIN")
    @PostMapping("personas")
    public ResponseEntity<?> store(@RequestBody Persona persona) {

        if (StringUtils.isBlank(persona.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getLast_name())) {
            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getJob())) {
            return new ResponseEntity(new Message("El trabajo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        iPersonaService.save(persona);
        return new ResponseEntity(new Message("Persona Agregada Correctamente."), HttpStatus.OK);

    }

    //@PreAuthorize("hasRole('ADMIN')")
    @Secured("ROLE_ADMIN")
    @PutMapping("personas/{id}/update")
    public ResponseEntity<?> update(@PathVariable int id, @RequestBody Persona persona) {

        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Message("La persona que buscas no existe."), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getName())) {
            return new ResponseEntity(new Message("El nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getLast_name())) {
            return new ResponseEntity(new Message("El apellido es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getJob())) {
            return new ResponseEntity(new Message("El trabajo es obligatorio"), HttpStatus.BAD_REQUEST);
        }

        if (StringUtils.isBlank(persona.getDescription())) {
            return new ResponseEntity(new Message("La descripción es obligatoria"), HttpStatus.BAD_REQUEST);
        }

        Persona old_persona = iPersonaService.show(id).get();
        old_persona.setName(persona.getName());
        old_persona.setLast_name(persona.getLast_name());
        old_persona.setJob(persona.getJob());
        old_persona.setDescription(persona.getDescription());
        old_persona.setImage(persona.getImage());

        iPersonaService.save(old_persona);
        return new ResponseEntity(new Message("Persona creada correctamente."), HttpStatus.OK);

    }

    @Secured("ROLE_ADMIN")
    @DeleteMapping("personas/{id}/delete")
    public ResponseEntity<?> delete(@PathVariable int id) {

        if (!iPersonaService.existsById(id)) {
            return new ResponseEntity(new Message("El id de la experiencia no existe."), HttpStatus.BAD_REQUEST);
        }

        iPersonaService.delete(id);
        return new ResponseEntity(new Message("Persona se eliminó correctamente."), HttpStatus.OK);

    }
}
