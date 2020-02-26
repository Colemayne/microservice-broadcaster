package com.coleman.broadcast.service;

import com.coleman.broadcast.domain.model.Message;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MessageService {
    Message saveMessage(Message message);
    List<Message> findAllMessages();
    void deleteMessage(int id);
}
