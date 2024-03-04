package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.repositories.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChatroomService {

    @Autowired
    ChatroomRepository chatroomRepository;

    public List<Chatroom> findAllChatrooms(){
        return chatroomRepository.findAll();
    }
}
