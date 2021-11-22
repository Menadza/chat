package com.kondratev.chat.auth.service;

import com.kondratev.chat.auth.model.Role;
import com.kondratev.chat.auth.model.User;
import com.kondratev.chat.auth.model.dto.SignUpRequestDto;
import com.kondratev.chat.auth.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.naming.NameAlreadyBoundException;

import java.util.Set;

@Service
@AllArgsConstructor(onConstructor_ = {@Autowired})
public class UserService implements UserDetailsService {

  private final UserRepository userRepository;
  private final PasswordEncoder bCryptPasswordEncoder;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username).orElseThrow(
        () -> new UsernameNotFoundException("Username was not found"));
  }

  public User registerNewUser(SignUpRequestDto signUpRequestDto) throws NameAlreadyBoundException {
    if (userRepository.findByUsername(signUpRequestDto.getUsername()).isPresent()) {
      throw new NameAlreadyBoundException("Username with this name already exists");
    } else {
      User newUser = new User();
      newUser.setUsername(signUpRequestDto.getUsername());
      newUser.setPassword(bCryptPasswordEncoder.encode(signUpRequestDto.getPassword()));
      newUser.setRoles(Set.of(new Role("USER")));
      return userRepository.save(newUser);
    }
  }

}
