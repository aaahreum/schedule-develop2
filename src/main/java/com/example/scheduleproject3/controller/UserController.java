package com.example.scheduleproject3.controller;

import com.example.scheduleproject3.dto.SignUpRequestDto;
import com.example.scheduleproject3.dto.SignUpResponseDto;
import com.example.scheduleproject3.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 유저 컨트롤러
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 등록
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){

        // userService.signUp() 메서드가 개별 필드 값(username, password, email)을 요구하는 이유?
        SignUpResponseDto SignUpResponseDto = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword(), signUpRequestDto.getUsername());

        return new ResponseEntity<>(SignUpResponseDto, HttpStatus.CREATED);
    }

}
