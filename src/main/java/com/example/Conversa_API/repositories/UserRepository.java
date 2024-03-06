package com.example.Conversa_API.repositories;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findDistinctByMessagesChatroomId(Long id);
}