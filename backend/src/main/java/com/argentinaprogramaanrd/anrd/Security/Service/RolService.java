/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Security.Service;

import com.argentinaprogramaanrd.anrd.Security.Enums.RolesName;
import com.argentinaprogramaanrd.anrd.Security.Entity.Rol;

import com.argentinaprogramaanrd.anrd.Security.Repository.IRolRepository;
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
public class RolService {

    @Autowired
    IRolRepository iRolRepository;

    public Optional<Rol> getByRolName(RolesName rolName) {
        return iRolRepository.findByRolName(rolName);
    }

    public void save(Rol rol) {
        iRolRepository.save(rol);
    }
}
