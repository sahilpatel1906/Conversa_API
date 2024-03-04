package com.example.Conversa_API.components;

import com.example.Conversa_API.models.Chatroom;
import com.example.Conversa_API.models.Message;
import com.example.Conversa_API.models.User;
import com.example.Conversa_API.repositories.ChatroomRepository;
import com.example.Conversa_API.repositories.MessageRepository;
import com.example.Conversa_API.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ChatroomRepository chatroomRepository;
    @Autowired
    UserRepository userRepository;

    public DataLoader(){}

    @Override
    public void run(ApplicationArguments args) throws Exception {

    User Yesica = new User("Yesica", "yesica@gmail.com");
    userRepository.save(Yesica);

    User Marvellous = new User("Marvellous", "marvellous@outlook.com");
    userRepository.save(Marvellous);

    User Jean = new User("Jean", "jean@hotmail.com");
    userRepository.save(Jean);

    User Aebel = new User("Aebel", "aebel@conversa.com");
    userRepository.save(Aebel);

    User Sahil = new User("Sahil", "sahil@yaoo.com");
    userRepository.save(Sahil);


    Chatroom axolotl = new Chatroom("Axolotl");
    chatroomRepository.save(axolotl);

    Chatroom gecko = new Chatroom("Gecko");
    chatroomRepository.save(gecko);

    Chatroom aploparaksis_turdi = new Chatroom("Aploparaksis Turdi");
    chatroomRepository.save(aploparaksis_turdi);



    Message message1 = new Message("Eat Kale, stay fit, die anyway", Yesica, gecko);
    messageRepository.save(message1);
    Message message2 = new Message("Believe in yourself. Someone has to.", Yesica, axolotl);
    messageRepository.save(message2);
    Message message3 = new Message("If, at first, you don’t succeed, destroy the evidence that you tried.", Jean, gecko);
    messageRepository.save(message3);
    Message message4 = new Message("Shush! I can’t hear what the voices are saying.", Marvellous, axolotl);
    messageRepository.save(message4);
    Message message5 = new Message("I said ‘No’ to drugs, but they wouldn’t listen.", Aebel, aploparaksis_turdi);
    messageRepository.save(message5);
    Message message6 = new Message("My parents moved a lot when I was a kid. But I always found them.", Yesica, axolotl);
    messageRepository.save(message6);
    Message message7 = new Message("You’ll meet three kinds of people in this world: those who can count and those who can’t.",Sahil, aploparaksis_turdi);
    messageRepository.save(message7);


    }
}
