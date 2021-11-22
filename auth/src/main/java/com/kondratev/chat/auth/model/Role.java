package com.kondratev.chat.auth.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@Table(name = "roles")
public class Role implements GrantedAuthority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  public Role(String authority) {
    this.authority = authority;
  }

  @Column(name = "authority")
  private String authority;

  @Override
  public String getAuthority() {
    return authority;
  }

/*  @ManyToMany(mappedBy = "roles")
  private Set<User> users;*/

}
