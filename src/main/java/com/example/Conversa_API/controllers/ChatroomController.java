package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.ChatroomDTO;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.services.ChatroomService;
import com.example.Conversa_API.services.MessageService;
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

    @Autowired
    MessageService messageService;


    @GetMapping(value = "/admin")
    public ResponseEntity<List<Chatroom>> getAllChatrooms(){
       return new ResponseEntity<>(chatroomService.findAllChatrooms(), HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Chatroom> getChatroomById(@PathVariable Long id) {
        Optional<Chatroom> chatroomOptional = chatroomService.findChatroomById(id);
        if (chatroomOptional.isEmpty()){
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(chatroomService.findChatroomById(id).get(), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity <List<Long>> filterByUserId(@RequestParam (required = true, name = "userId") Long userId){
        return new ResponseEntity<>(messageService.filterByUserId(userId), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<Chatroom> addNewChatroom(@RequestBody ChatroomDTO chatroomDTO){
        Chatroom chatroom = chatroomService.saveChatroom(chatroomDTO);
        return new ResponseEntity<>(chatroom, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Chatroom> updateChatroomById(@RequestBody ChatroomDTO chatroomDTO, @PathVariable Long id){
        Chatroom chatroom = chatroomService.updateChatroomById(chatroomDTO, id);
        return new ResponseEntity<>(chatroom, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public  ResponseEntity<Chatroom> deleteChatroomById(@PathVariable Long id) {
        Optional<Chatroom> chatroomOptional = chatroomService.deleteChatroomById(id);
        if (chatroomOptional.isPresent()){
            return new ResponseEntity<>(chatroomOptional.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

}
