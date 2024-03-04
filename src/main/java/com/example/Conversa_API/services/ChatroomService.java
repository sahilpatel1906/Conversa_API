package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.ChatroomDTO;
import com.example.Conversa_API.repositories.ChatroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatroomService {

    @Autowired
    ChatroomRepository chatroomRepository;

    public List<Chatroom> findAllChatrooms(){
        return chatroomRepository.findAll();
    }

    public Optional<Chatroom> findChatroomById(Long id) {
        return chatroomRepository.findById(id);
    }

    public Chatroom saveChatroom(ChatroomDTO chatroomDTO){
        Chatroom chatroom = new Chatroom(chatroomDTO.getName());
        chatroomRepository.save(chatroom);
        return chatroom;
    }

}
