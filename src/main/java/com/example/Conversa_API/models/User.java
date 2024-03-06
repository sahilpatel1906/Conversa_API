package com.example.Conversa_API.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity(name = "users")
public class User {

   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private long id;

   @Column (name = "username")
   private String username;

   @Column (name = "email")
   private String email;

   @OneToMany(mappedBy = "user")
   @JsonIgnore
   private List<Message> messages;

   @Column (name = "profile_picture")
   @JsonIgnore
   private byte[] profilePicture;

   public User (String username, String email){
       this.username = username;
       this.email = email;
       this.messages = new ArrayList<>();
       this.profilePicture = null;
   }

   public User(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public List<Message> getMessages() {
        return messages;
    }

    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }
}

