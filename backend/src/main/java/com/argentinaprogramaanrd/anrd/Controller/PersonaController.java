/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Controller;

import com.argentinaprogramaanrd.anrd.Entity.Persona;
import com.argentinaprogramaanrd.anrd.Interface.IPersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author operador
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PersonaController {

    @Autowired
    IPersonaService iPersonaService;

    @GetMapping("personas")
    public List<Persona> index() {
        return iPersonaService.index();
    }

    @GetMapping("personas/show/{id}")
    public Persona show(@PathVariable Long id) {
        return iPersonaService.show(id);
    }

    @PostMapping("personas")
    public String save(@RequestBody Persona persona) {
        iPersonaService.save(persona);
        return "Persona creada correctamente";
    }

    @PutMapping("personas/update/{id}")
    public Persona edit(@PathVariable Long id,
            @RequestBody Persona persona
    ) {
        Persona old_persona = iPersonaService.show(id);
        
        old_persona.setName(persona.getName());
        old_persona.setLast_name(persona.getLast_name());
        old_persona.setJob(persona.getJob());
        old_persona.setDescription(persona.getDescription());
        old_persona.setImage(persona.getImage());

        iPersonaService.save(persona);

        return old_persona;

    }

    @DeleteMapping("personas/delete/{id}")
    public String delete(@PathVariable Long id) {
        iPersonaService.delete(id);
        return "Persona eliminada correctamente";

    }
}
