package com.example.scheduleproject3.controller;

import com.example.scheduleproject3.common.Const;
import com.example.scheduleproject3.dto.SignUpRequestDto;
import com.example.scheduleproject3.dto.SignUpResponseDto;
import com.example.scheduleproject3.dto.UserRequestDto;
import com.example.scheduleproject3.dto.UserResponseDto;
import com.example.scheduleproject3.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 유저 컨트롤러
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // 유저 등록
    @PostMapping("/signup")
    public ResponseEntity<SignUpResponseDto> signUp(@RequestBody SignUpRequestDto signUpRequestDto){

        // userService.signUp() 메서드가 개별 필드 값(username, password, email)을 요구하는 이유?
        SignUpResponseDto signUpResponseDto = userService.signUp(signUpRequestDto.getEmail(), signUpRequestDto.getPassword(), signUpRequestDto.getUsername());

        return new ResponseEntity<>(signUpResponseDto, HttpStatus.CREATED);
    }

    // 유저 전체 조회
    @GetMapping("/users")
    public ResponseEntity<List<UserResponseDto>> findAllUsers(){

        List<UserResponseDto> userResponseDtolist = userService.findAllUsers();

        return new ResponseEntity<>(userResponseDtolist, HttpStatus.OK);
    }

    // 특정 유저 조회
    @GetMapping("/users/{id}")
    public ResponseEntity<UserResponseDto> findUserById(@PathVariable Long id){

        UserResponseDto userResponseDto = userService.findUserById(id);

        return new ResponseEntity<>(userResponseDto, HttpStatus.OK);
    }

    // 유저 삭제
    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id){

        userService.deleteUser(id);

    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody UserRequestDto userRequestDto, HttpServletRequest request){

        String successMessage = userService.login(userRequestDto.getEmail(), userRequestDto.getPassword());

        HttpSession session = request.getSession(true);

        // 이메일로 회원 정보 조회
        UserResponseDto loginUser = userService.findUserByEmail(userRequestDto.getEmail());

        // Session에 로그인 회원 정보 저장
        session.setAttribute(Const.LOGIN_USER, loginUser);

        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }

        return new ResponseEntity<>("로그아웃 되었습니다.", HttpStatus.OK);
    }
}
