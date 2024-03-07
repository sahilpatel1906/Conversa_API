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

import java.io.ObjectInputStream;
import java.util.*;

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
        // check if chatroom is 1. if true then askTheLotl.
        Message message = messageService.saveMessage(messageDTO);
        return new ResponseEntity<>(message, HttpStatus.CREATED);
    }

    @PostMapping(value = "/{id}/askTheLotl")
    public ResponseEntity<Message> askTheLotl(@PathVariable long id, @RequestBody String message){
        long axolotlChatroomId = 1;
        long askolotlUserId = 1;
        List<String> responses = new ArrayList<>(Arrays.asList(
                "HELLO I AM ASKALOTL",
                "I DONT KNOW THAT, I JUST AN AXALOTL 🥺",
                "LIFE IS LIKE A SANDWICH, THE BREAD COMES FIRST 💯",
                "WHY DO THEY CALL IT OVEN, WHEN YOU OF IN THE COLD OF FOOD OUT HOT EAT THE FOOD",
                "WE BALL, JUST DO IT",
                "WHEN YOU AT THE WHEN YOU WHEN THE",
                "HAVE YOU EVER HAD A DREAM WHERE",
                "YOU MISS 100% OF THE SHOTS YOU DON'T TAKE"
        ));
        Random rand = new Random();
        String aiResponseMessage = responses.get(rand.nextInt(responses.size()));
        MessageDTO messageDTO = new MessageDTO(message, id, axolotlChatroomId);
        messageService.saveMessage(messageDTO);
        MessageDTO aiResponseDTO = new MessageDTO(aiResponseMessage, askolotlUserId, axolotlChatroomId);
        Message aiResponse = messageService.saveMessage(aiResponseDTO);
        return new ResponseEntity<Message>(aiResponse, HttpStatus.CREATED);
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
