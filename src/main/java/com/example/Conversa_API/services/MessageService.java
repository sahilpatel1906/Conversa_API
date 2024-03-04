package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.repositories.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {

    @Autowired
    MessageRepository messageRepository;

    public List<Message> getAllMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> findMessage(long id) {
        return messageRepository.findById(id);
    }
}
