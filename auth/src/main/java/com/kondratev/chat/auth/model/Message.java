package com.kondratev.chat.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@Table(name = "messages")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  @ManyToOne
  private User user;

  @Column(name = "text")
  @NotEmpty(message = "Message should be contain text")
  private String text;

  @Column(name = "date")
  private LocalDateTime date;
}
