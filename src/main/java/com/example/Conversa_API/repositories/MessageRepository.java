package com.example.Conversa_API.repositories;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {



//    SELECT DISTINCT chatroom_id FROM messages WHERE user_id = 1




}





//    SELECT DISTINCT user_id FROM messages WHERE chatroom_id = 1