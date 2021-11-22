package com.kondratev.chat.auth.repository;

import com.kondratev.chat.auth.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
  Optional<User> findByUsername(String username);
}
