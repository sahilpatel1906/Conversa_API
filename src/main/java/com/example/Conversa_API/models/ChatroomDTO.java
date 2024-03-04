package com.example.Conversa_API.models;

import java.util.List;

public class ChatroomDTO {

    private String name;

    private List<Message> messageIds;

    public ChatroomDTO() {
    }

    public ChatroomDTO(String name, List<Message> messageIds) {
        this.name = name;
        this.messageIds = messageIds;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Message> getMessageIds() {
        return messageIds;
    }

    public void setMessageIds(List<Message> messageIds) {
        this.messageIds = messageIds;
    }
}
