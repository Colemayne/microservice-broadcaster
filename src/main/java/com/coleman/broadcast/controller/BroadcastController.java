package com.coleman.broadcast.controller;

import com.coleman.broadcast.domain.model.Message;
import com.coleman.broadcast.repository.MessageRepository;
import com.coleman.broadcast.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/message/v1")
public class BroadcastController {

    @Autowired
    private MessageService messageService;

    @RequestMapping(path = "/alive", method = RequestMethod.GET)
    public ResponseEntity<String> alive() {
        return ResponseEntity.ok().body("alive");
    }

    @RequestMapping(path = "/save", method = RequestMethod.POST)
    public ResponseEntity<Message> saveMessage(@RequestBody Message message) {
        LocalDateTime now = LocalDateTime.now();
        message.setTime(now);
        return ResponseEntity.ok().body(messageService.saveMessage(message));
    }

    @RequestMapping(path = "/select", method = RequestMethod.GET)
    public ResponseEntity<List<Message>> getMessages(){
        return ResponseEntity.ok().body(messageService.findAllMessages());
    }

    @RequestMapping(path = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity deleteMessage(@PathVariable Integer id) {
        try {
            messageService.deleteMessage(id);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }

    }




}
