package com.example.Conversa_API.models;

public class MessageDTO {

    private String message;

    private Long userId;

    private Long chatroomId;

    public MessageDTO(){}

    public MessageDTO(String message, Long userId, Long chatroomId){
        this.message = message;
        this.userId = userId;
        this.chatroomId = chatroomId;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getChatroomId() {
        return chatroomId;
    }

    public void setChatroomId(Long chatroomId) {
        this.chatroomId = chatroomId;
    }
}
