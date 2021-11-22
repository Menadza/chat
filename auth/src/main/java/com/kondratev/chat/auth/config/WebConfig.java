package com.kondratev.chat.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/signin").setViewName("signin");
    registry.addViewController("/entrance").setViewName("entrance");
    registry.addRedirectViewController("/","/entrance");
    registry.addViewController("/chat/start").setViewName("start");
  }

}
