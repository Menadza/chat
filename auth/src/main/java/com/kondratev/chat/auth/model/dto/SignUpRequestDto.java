package com.kondratev.chat.auth.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequestDto {
  @NotEmpty(message = "username should not be empty")
  @Size(min = 6, max = 15, message = "Username should be contain 6-15 characters")
  private String username;
  @NotEmpty(message = "Password should not be empty")
  @Size(min = 6, max = 15, message = "Password should be contain 6-15 characters")
  private String password;
  @NotEmpty(message = "Password should not be empty")
  @Size(min = 6, max = 15, message = "Password should be contain 6-15 characters")
  private String confirmPassword;

}
