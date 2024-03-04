package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.ChatroomDTO;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.repositories.ChatroomRepository;
import com.example.Conversa_API.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ChatroomService {

    @Autowired
    ChatroomRepository chatroomRepository;

    @Autowired
    MessageRepository messageRepository;

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

    public Optional<Chatroom> deleteChatroomById(Long id) {
        Optional<Chatroom> chatroomOptional = chatroomRepository.findById(id);
        if (chatroomOptional.isPresent()) {
            Chatroom chatroom = chatroomOptional.get();
            List<Message> messagesToDelete = chatroom.getMessages();
            for (Message message : messagesToDelete) {
                messageRepository.deleteById(message.getId());
            }
            chatroomRepository.deleteById(id);
        }
        return chatroomOptional;
    }
}
