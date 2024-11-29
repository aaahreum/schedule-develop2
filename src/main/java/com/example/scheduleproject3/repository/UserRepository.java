package com.example.scheduleproject3.repository;

import com.example.scheduleproject3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
}
