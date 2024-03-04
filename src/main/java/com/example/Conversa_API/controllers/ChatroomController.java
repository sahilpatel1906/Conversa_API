package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.services.ChatroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("chatrooms")
public class ChatroomController {

    @Autowired
    ChatroomService chatroomService;


    @GetMapping
    public ResponseEntity<List<Chatroom>> getAllChatrooms(){
       return new ResponseEntity<>(chatroomService.findAllChatrooms(), HttpStatus.OK);
   }

}
