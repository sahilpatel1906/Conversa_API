package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.ChatroomDTO;
import com.example.Conversa_API.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.security.auth.callback.CallbackHandler;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;


    @GetMapping
    public ResponseEntity<List<Chatroom>> getAllChatrooms(){
       return new ResponseEntity<>(chatroomService.findAllChatrooms(), HttpStatus.OK);
    }
    @GetMapping(value = "/admin/{id}")
    public ResponseEntity<Chatroom> getChatroomById(@PathVariable Long id) {
        Optional<Chatroom> chatroomOptional = chatroomService.findChatroomById(id);
        if (chatroomOptional.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chatroomService.findChatroomById(id).get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Chatroom> addNewChatroom(@RequestBody ChatroomDTO chatroomDTO){
        Chatroom chatroom = chatroomService.saveChatroom(chatroomDTO);
        return new ResponseEntity<>(chatroom, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/admin/{id}")
    public  ResponseEntity<Chatroom> deleteChatroomById(@PathVariable Long id) {
        Optional<Chatroom> chatroomOptional = chatroomService.deleteChatroomById(id);
        if (chatroomOptional.isPresent()){
            return new ResponseEntity<>(chatroomOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
