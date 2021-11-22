package com.kondratev.chat.auth.config;

import com.kondratev.chat.auth.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  public final static String LOGIN = "/signin";
  @Autowired
  private UserService userService;

  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .formLogin()
        .loginPage(LOGIN)
        .loginProcessingUrl(LOGIN)
        .defaultSuccessUrl("/start", true)

        .and()
        .authorizeRequests()
        .antMatchers("/chat/**")
        .hasAuthority("USER")

        .and()
        .authorizeRequests()
        .antMatchers("/signup","signin")
        .anonymous()

        .and()
        .authorizeRequests()
        .antMatchers("/start")
        .permitAll()

        .and()
        .logout()
        .logoutUrl("/logout")

        .and()
        .csrf().disable();
  }

  @Override
  public void configure(AuthenticationManagerBuilder auth){
    auth.authenticationProvider(authProvider());
  }

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userService);
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public DaoAuthenticationProvider authProvider(){
    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
    authProvider.setUserDetailsService(userService);
    authProvider.setPasswordEncoder(passwordEncoder());
    return authProvider;
  }

}
