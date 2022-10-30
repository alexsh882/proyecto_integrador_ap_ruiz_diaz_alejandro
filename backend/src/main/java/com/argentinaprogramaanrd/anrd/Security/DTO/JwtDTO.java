/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.argentinaprogramaanrd.anrd.Security.DTO;

import java.util.Collection;
import org.springframework.security.core.GrantedAuthority;

/**
 *
 * @author Alejandro
 */
public class JwtDTO {
    private String token;
    private String bearer = "Bearer";
    private String username;
    private Collection<? extends GrantedAuthority> authAutorities;
    
    //Constructor

    public JwtDTO(String token, String username, Collection<? extends GrantedAuthority> authAutorities) {
        this.token = token;
        this.username = username;
        this.authAutorities = authAutorities;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getBearer() {
        return bearer;
    }

    public void setBearer(String bearer) {
        this.bearer = bearer;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Collection<? extends GrantedAuthority> getAuthAutorities() {
        return authAutorities;
    }

    public void setAuthAutorities(Collection<? extends GrantedAuthority> authAutorities) {
        this.authAutorities = authAutorities;
    }
    
    
    
    
}
