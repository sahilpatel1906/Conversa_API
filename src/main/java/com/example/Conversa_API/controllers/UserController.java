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

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity <List<User>> getAllUsersAndFilters(@RequestParam (required = false, name = "chatroomId") Long chatroomId){
        if(chatroomId != null){
            return new ResponseEntity<>(userService.filterByChatroomId(chatroomId), HttpStatus.OK);
        }
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
    public ResponseEntity<String> getUserProfilePicture(@PathVariable Long id){
        Optional<User> userOptional = userService.findUser(id);
        if(userOptional.isPresent()){
            String image = userService.getProfilePicture(id);
            return new ResponseEntity<>(image, HttpStatus.OK);

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
                exception.printStackTrace();
                return new ResponseEntity<>(null, HttpStatus.FORBIDDEN);
            }
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
}
