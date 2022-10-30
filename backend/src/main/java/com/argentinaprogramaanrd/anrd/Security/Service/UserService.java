/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Security.Service;

import com.argentinaprogramaanrd.anrd.Security.Repository.IUserRepository;
import com.argentinaprogramaanrd.anrd.Security.Entity.User;
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
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public Optional<User> getByUsername(String username) {
        return iUserRepository.findByUsername(username);
    }

    public boolean existsByUsername(String username) {
        return iUserRepository.existsByUsername(username);
    }

    public boolean existsByEmail(String email) {
        return iUserRepository.existsByEmail(email);
    }

    public void save(User user) {
        iUserRepository.save(user);
    }
}
