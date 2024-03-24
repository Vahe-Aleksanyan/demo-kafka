package com.example.demokafka.repo;

import com.example.demokafka.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepo extends JpaRepository<User, Long> {

}
