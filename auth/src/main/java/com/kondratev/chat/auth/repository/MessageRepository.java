package com.kondratev.chat.auth.repository;

import com.kondratev.chat.auth.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message,Long> {

}
