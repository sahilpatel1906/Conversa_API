package com.example.Conversa_API.services;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.models.User;
import com.example.Conversa_API.models.UserDTO;
import com.example.Conversa_API.repositories.MessageRepository;
import com.example.Conversa_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    MessageRepository messageRepository;


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> findUser(Long id) {
        return userRepository.findById(id);
    }

    public User saveUser(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getEmail());
        return userRepository.save(user);
    }

    public Optional<User> deleteUser(Long id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()){
            User user = userOptional.get();
            List<Message> messagesToDelete = user.getMessages();
            for (Message message : messagesToDelete){
                messageRepository.deleteById(message.getId());
            }
            userRepository.deleteById(id);
        }
        return userOptional;
    }

    public User updateUserById(UserDTO userDTO, Long id) {
        User userToUpdate = userRepository.findById(id).get();
        userToUpdate.setUsername(userDTO.getUsername());
        userToUpdate.setEmail(userDTO.getEmail());
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public List<User> filterByChatroomId(Long chatroomId) {
        return userRepository.findDistinctByMessagesChatroomId(chatroomId);
    }

    public User updateProfilePicture(MultipartFile imageFile, Long id) throws IOException {
        User userToUpdate = userRepository.findById(id).get();
        Path path = Paths.get("./images");
        if (!Files.exists(path)){
            Files.createDirectories(path);
        }
        Path filePath = path.resolve(id + ".png");
        Files.copy(imageFile.getInputStream(), filePath, StandardCopyOption.REPLACE_EXISTING);
        userToUpdate.setProfilePicture("./images" + id + ".png");
        userRepository.save(userToUpdate);
        return userToUpdate;
    }

    public String getProfilePicture(Long id) {
        User user = userRepository.findById(id).get();
        return user.getProfilePicture();
    }
}
