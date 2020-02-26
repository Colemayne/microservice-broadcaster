package com.coleman.broadcast.service;

import com.coleman.broadcast.domain.model.Message;
import com.coleman.broadcast.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepository messageRepository;

    @Override
    public Message saveMessage(Message message) {
        return messageRepository.save(message);
    }

    @Override
    public List<Message> findAllMessages() {
        return messageRepository.findAll();
    }

    @Transactional
    @Override
    public void deleteMessage(int id){
        messageRepository.deleteById(id);
    }


}
