package com.example.scheduleproject3.service;

import com.example.scheduleproject3.dto.SignUpResponseDto;
import com.example.scheduleproject3.entity.User;
import com.example.scheduleproject3.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // 유저 생성
    public SignUpResponseDto signUp(String email, String password, String username ) {
        User user = new User(email, password, username);
        User savedUser = userRepository.save(user);
        return new SignUpResponseDto(savedUser.getId(),savedUser.getUsername(), savedUser.getEmail());
    }
    //

    // 유저 전체 조회

    // 유저
}
