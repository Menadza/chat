package com.kondratev.chat.auth.controller;

import com.kondratev.chat.auth.model.Message;
import com.kondratev.chat.auth.service.MessageService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

  private SimpMessageSendingOperations simpMessagingTemplate;
  private MessageService messageService;

  public ChatController(SimpMessageSendingOperations simpMessagingTemplate, MessageService messageService) {
    this.simpMessagingTemplate = simpMessagingTemplate;
    this.messageService = messageService;
  }

  @MessageMapping("/message")
  @SendTo("/chat/messages")
  public Message getMessages(Message message) {
    Message savedMessage = messageService.saveMessage(message);
    System.out.println(savedMessage);
    return savedMessage;
  }

}
