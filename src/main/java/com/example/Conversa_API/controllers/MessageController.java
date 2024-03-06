package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.models.MessageDTO;
import com.example.Conversa_API.models.User;
import com.example.Conversa_API.repositories.MessageRepository;
import com.example.Conversa_API.services.MessageService;
import com.example.Conversa_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/messages")
public class MessageController {

    @Autowired
    MessageService messageService;

    @GetMapping(value = "/admin")
    public ResponseEntity<List<Message>> getAllMessages(){
        List<Message> messages = messageService.getAllMessages();
        return new ResponseEntity<>(messages, HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Message> getMessageById(@PathVariable long id){
        Optional<Message> foundMessage = messageService.findMessage(id);
        if(foundMessage.isPresent()){
            return new ResponseEntity<>(foundMessage.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<Message> addNewMessage(@RequestBody MessageDTO messageDTO) {
        Message message = messageService.saveMessage(messageDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Message> deleteMessage(@PathVariable Long id){
        Optional<Message> deletedMessage = messageService.deleteMessage(id);
        if(deletedMessage.isPresent()){
            return new ResponseEntity<>(deletedMessage.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Message> updateMessage(@PathVariable Long id, @RequestBody String message) {
        Optional<Message> messageOptional = messageService.findMessage(id);
        if (messageOptional.isPresent()) {
            Message updatedMessage = messageService.updateMessageById(id, message);
            return new ResponseEntity<>(updatedMessage, HttpStatus.OK);

        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


}
