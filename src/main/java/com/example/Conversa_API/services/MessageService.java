package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.models.MessageDTO;
import com.example.Conversa_API.models.User;
import com.example.Conversa_API.repositories.ChatroomRepository;
import com.example.Conversa_API.repositories.MessageRepository;
import com.example.Conversa_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChatroomRepository chatroomRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> findMessage(long id) {
        return messageRepository.findById(id);
    }

    public Message saveMessage(MessageDTO messageDTO) {
        Optional<User> userOptional = userRepository.findById(messageDTO.getUserId());
        Optional<Chatroom> chatroomOptional = chatroomRepository.findById(messageDTO.getChatroomId());
        User user = new User();
        Chatroom chatroom = new Chatroom();
        if (userOptional.isPresent() ) {
            user = userOptional.get();
        }
        if (chatroomOptional.isPresent()) {
            chatroom = chatroomOptional.get();
        }
        Message message = new Message(messageDTO.getMessage(), user, chatroom);
        messageRepository.save(message);
        return message;
    }

    public Optional<Message> deleteMessage(Long id) {
        Optional<Message> message =  messageRepository.findById(id);
        messageRepository.deleteById(id);
        return message;
    }

    public Message updateMessageById(Long id, String message) {
        Message messageToUpdate = messageRepository.findById(id).get();
        messageToUpdate.setMessage(message);
        return messageRepository.save(messageToUpdate);
    }
}
