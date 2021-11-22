package com.kondratev.chat.auth.service;

import com.kondratev.chat.auth.model.Message;

public interface MessageService {
  public Message saveMessage(Message message);

}
