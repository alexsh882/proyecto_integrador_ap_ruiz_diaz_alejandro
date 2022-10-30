/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Repository;

import com.argentinaprogramaanrd.anrd.Entity.ExperienciaLaboral;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public interface IExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Integer> {
    
    public Optional<ExperienciaLaboral> findByName(String name);
    public boolean existsByName(String name);
    
}
