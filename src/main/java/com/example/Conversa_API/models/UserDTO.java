package com.example.Conversa_API.models;


public class UserDTO {

    private String username;
    private String email;

    public UserDTO(){}

    public UserDTO(String username, String email){
        this.username = username;
        this.email = email;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
