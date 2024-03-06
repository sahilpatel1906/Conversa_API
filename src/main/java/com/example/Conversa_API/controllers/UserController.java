package com.example.Conversa_API.controllers;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.User;
import com.example.Conversa_API.models.UserDTO;
import com.example.Conversa_API.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;


    @GetMapping(value = "/admin")
    public ResponseEntity<List<User>> getAllUsers(){
      List<User> users = userService.getAllUsers();
      return new ResponseEntity<>(users, HttpStatus.OK);
    }


    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> foundUser = userService.findUser(id);
        if(foundUser.isPresent()){
            return new ResponseEntity<>(foundUser.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @GetMapping
    public ResponseEntity <List<User>> filterByChatroomId(@RequestParam (required = true, name = "chatroomId") Long chatroomId){
        return new ResponseEntity<>(userService.filterByChatroomId(chatroomId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addNewUser(@RequestBody UserDTO userDTO){
      User newUser = userService.saveUser(userDTO);
      return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<User> updateUserById(@RequestBody UserDTO userDTO, @PathVariable Long id){
        User user = userService.updateUserById(userDTO, id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
       Optional<User> deletedUser = userService.deleteUser(id);
       if(deletedUser.isPresent()){
           return new ResponseEntity<>(deletedUser.get(), HttpStatus.OK);
       }
       return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }


    @GetMapping(value = "/{id}/profilePicture")
    public ResponseEntity<?> getUserProfilePicture(@PathVariable Long id){
        Optional<User> userOptional = userService.findUser(id);
        if(userOptional.isPresent()){
            byte[] image = userService.getProfilePicture(id);
            return ResponseEntity.status(HttpStatus.OK)
                    .contentType(MediaType.valueOf("image/png"))
                    .body(image);


        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);


    }

    @PatchMapping(value = "/{id}/profilePicture")
    public ResponseEntity<User> updateUserProfilePicture(@RequestParam("image") MultipartFile imageFile, @PathVariable Long id) {
        Optional<User> userOptional = userService.findUser(id);
        if(userOptional.isPresent()){
            try {
                return new ResponseEntity<>(userService.updateProfilePicture(imageFile, id), HttpStatus.OK);
            } catch(IOException exception) {
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
