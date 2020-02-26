package com.coleman.broadcast.repository;

import com.coleman.broadcast.domain.model.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Integer> {
  Message findById(int id);
  List<Message> findAll();
}
