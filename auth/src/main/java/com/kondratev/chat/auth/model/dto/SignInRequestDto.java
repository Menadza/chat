package com.kondratev.chat.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequestDto {

  @NotEmpty(message = "username should not be empty")
  private String username;
  @NotEmpty(message = "username should not be empty")
  private String password;

}
