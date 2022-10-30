/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Security.Controller;

import com.argentinaprogramaanrd.anrd.Security.Controller.Helpers.Message;
import com.argentinaprogramaanrd.anrd.Security.DTO.JwtDTO;
import com.argentinaprogramaanrd.anrd.Security.DTO.LoginUser;
import com.argentinaprogramaanrd.anrd.Security.DTO.NewUser;
import com.argentinaprogramaanrd.anrd.Security.Entity.Rol;
import com.argentinaprogramaanrd.anrd.Security.Entity.User;
import com.argentinaprogramaanrd.anrd.Security.Enums.RolesName;
import com.argentinaprogramaanrd.anrd.Security.Jwt.JwtProvider;
import com.argentinaprogramaanrd.anrd.Security.Service.RolService;
import com.argentinaprogramaanrd.anrd.Security.Service.UserService;
import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alejandro
 */
@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    UserService userService;
    @Autowired
    RolService rolService;
    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/store")
    public ResponseEntity<?> store(@Valid @RequestBody NewUser newUser, BindingResult bindingResult
    ) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos Incorrectos o email inválido"), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByUsername(newUser.getUsername())) {
            return new ResponseEntity(new Message("El nombre de usuario ya existe."), HttpStatus.BAD_REQUEST);
        }
        if (userService.existsByEmail(newUser.getEmail())) {
            return new ResponseEntity(new Message("El email de usuario ya existe."), HttpStatus.BAD_REQUEST);
        }
        User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(), passwordEncoder.encode(newUser.getPassword()));
        Set<Rol> roles = new HashSet<>();
        roles.add(rolService.getByRolName(RolesName.ROLE_USER).get());
        
        if (newUser.getRoles().contains("admin")) {
            roles.add(rolService.getByRolName(RolesName.ROLE_ADMIN).get());
        }
        user.setRoles(roles);
        userService.save(user);

        return new ResponseEntity(new Message("Usuario guardado correctamente."), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDTO> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return new ResponseEntity(new Message("Campos Incorrectos"), HttpStatus.BAD_REQUEST);
        }
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginUser.getUsername(), loginUser.getPassword()
        ));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtProvider.generateToken(authentication);

        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        JwtDTO jwtDto = new JwtDTO(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}
