/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Security.Repository;

import com.argentinaprogramaanrd.anrd.Security.Entity.Rol;
import com.argentinaprogramaanrd.anrd.Security.Enums.RolesName;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Alejandro
 */
@Repository
public interface IRolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol>findByRolName(RolesName rol);
}
 