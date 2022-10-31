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
public class Persona {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
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

    public Persona() {
    }

    public Persona(String name, String last_name, String job, String description, String image) {
        this.name = name;
        this.last_name = last_name;
        this.job = job;
        this.description = description;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    
    
    
}
