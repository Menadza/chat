package com.kondratev.chat.auth.service;

import com.kondratev.chat.auth.model.Message;
import com.kondratev.chat.auth.repository.MessageRepository;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
  private MessageRepository messageRepository;

  public MessageServiceImpl(MessageRepository messageRepository) {
    this.messageRepository = messageRepository;
  }

  @Override
  public Message saveMessage(Message message) {
    return messageRepository.save(message);
  }

}
