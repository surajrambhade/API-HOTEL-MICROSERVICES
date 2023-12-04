package com.lcdw.user.service.repository;

import com.lcdw.user.service.entites.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

    // if you want to implemennt any custom method or query
    // write here
}
