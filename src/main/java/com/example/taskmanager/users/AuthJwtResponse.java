package com.example.taskmanager.users;

import java.util.List;

public class AuthJwtResponse {
    private Long id;
    private String token;
    private String type;
    private String username;
    private String email;
    private List<String> roles;

    public AuthJwtResponse(String token, Long id, String username, String email, List<String> roles) {
        this.id = id;
        this.token = token;
        this.username = username;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
