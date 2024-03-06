package com.example.Conversa_API.repositories;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ChatroomRepository extends JpaRepository<Chatroom, Long> {
    List<Chatroom> findDistinctByMessagesUserId(Long id);
}
