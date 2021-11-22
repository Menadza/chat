package com.kondratev.chat.auth.repository;

import com.kondratev.chat.auth.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
