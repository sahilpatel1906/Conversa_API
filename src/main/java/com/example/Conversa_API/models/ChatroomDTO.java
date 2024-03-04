package com.example.Conversa_API.models;

import java.util.List;

public class ChatroomDTO {

    private String name;


    public ChatroomDTO() {
    }

    public ChatroomDTO(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
