/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author operador
 */
@Entity
@Getter @Setter
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min=1,max=191, message= "Tenes que ingregar algun valor para nombres.")
    private String name;

    @NotNull
    @Size(min=1,max=191, message= "Tenes que ingregar algun valor para apellidos.")
    private String last_name;
    
    @NotNull
    @Size(min=1,max=191, message= "Tenes que ingregar algun valor para trabajo.")
    private String job;
    
    @NotNull
    @Column(columnDefinition = "TEXT")
    @Size(min=1, message= "Tenes que ingregar algun valor para descripción.")
    private String description;

    @Size(min=1,max=191, message= "Tenes que ingregar algun valor para imagen.")
    private String image;
    
}
