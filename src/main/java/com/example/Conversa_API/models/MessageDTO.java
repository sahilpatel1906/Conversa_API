package com.example.Conversa_API.models;

public class MessageDTO {

    private String message;

    public MessageDTO(){}

    public MessageDTO(String message){
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
