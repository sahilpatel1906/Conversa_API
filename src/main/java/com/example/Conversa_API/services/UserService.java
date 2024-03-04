package com.example.Conversa_API.services;

import com.example.Conversa_API.models.User;
import com.example.Conversa_API.models.UserDTO;
import com.example.Conversa_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


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
        Optional<User> user =  userRepository.findById(id);
        userRepository.deleteById(id);
        return user;
    }
}
