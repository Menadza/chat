package com.kondratev.chat.auth.controller;

import com.kondratev.chat.auth.model.dto.SignUpRequestDto;
import com.kondratev.chat.auth.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.NameAlreadyBoundException;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @GetMapping("/signup")
  public ModelAndView signUp(ModelAndView modelAndView) {
    modelAndView.setViewName("signup");
    modelAndView.addObject("signUpRequestDto", new SignUpRequestDto());
    return modelAndView;
  }

  @PostMapping("/signup")
  public ModelAndView userRegistration(@Valid @ModelAttribute SignUpRequestDto request,
                                       BindingResult bindingResult, ModelAndView modelAndView)
      throws NameAlreadyBoundException {
    if (bindingResult.hasErrors()) {
      modelAndView.setViewName("signup");
      bindingResult.addError(validatePassword(request));
      return modelAndView;
    } else {
      userService.registerNewUser(request);
      modelAndView.setViewName("entrance");
      return modelAndView;
    }
  }

  private ObjectError validatePassword(SignUpRequestDto request) {
    if (!request.getPassword().equals(request.getConfirmPassword())) {
      return new ObjectError("SignUpRequestDto", "Confirm password doesn't match");
    }
    return null;
  }

}
