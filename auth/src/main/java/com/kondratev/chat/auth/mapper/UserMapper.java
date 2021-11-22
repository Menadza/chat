package com.kondratev.chat.auth.mapper;

import com.kondratev.chat.auth.model.Role;
import com.kondratev.chat.auth.model.User;
import com.kondratev.chat.auth.model.dto.SignUpRequestDto;

import java.util.Set;

public class UserMapper {
  public static User userRequestToUser(SignUpRequestDto signUpRequestDto){
    User newUser = new User();
    newUser.setUsername(signUpRequestDto.getUsername());
    newUser.setPassword(signUpRequestDto.getPassword());
    newUser.setRoles(Set.of(new Role("USER")));
    return newUser;
  }
}
