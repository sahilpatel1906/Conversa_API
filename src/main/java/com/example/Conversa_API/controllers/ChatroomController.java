package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.ChatroomDTO;
import com.example.Conversa_API.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

   @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Chatroom>> getChatroomById(@PathVariable Long id) {
       Optional<Chatroom> chatroomOptional = chatroomService.findChatroomById(id);
       if (chatroomOptional.isEmpty()){
           return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(chatroomService.findChatroomById(id), HttpStatus.OK);
   }

   @PostMapping
    public ResponseEntity<Chatroom> addNewChatroom(@RequestBody ChatroomDTO chatroomDTO){
        Chatroom chatroom = chatroomService.saveChatroom(chatroomDTO);
        return new ResponseEntity<>(chatroom, HttpStatus.CREATED);
   }

}
