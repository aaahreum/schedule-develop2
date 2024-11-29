package com.example.scheduleproject3.service;

import com.example.scheduleproject3.dto.SignUpResponseDto;
import com.example.scheduleproject3.dto.UserResponseDto;
import com.example.scheduleproject3.entity.User;
import com.example.scheduleproject3.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    // 전체 유저 조회
    public List<UserResponseDto> findAllUsers() {
        List<User> userList = userRepository.findAll();
        // 변환 후 반환
        return userList.stream().map(UserResponseDto::toDto).toList();
    }

    // 특정 유저 조회
    public UserResponseDto findUserById(Long id) {

        // userRepository.findById(id) -> Optional<User> 반환
        Optional<User> optionalUser = userRepository.findById(id);

        if(optionalUser.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID가 존재하지 않습니다.");
        }

        User findUser = optionalUser.get();
        return new UserResponseDto(findUser.getEmail(), findUser.getUsername());

    }

    // 유저 삭제
    public void deleteUser(Long id) {
        User user = userRepository.findByIdOrElseThrow(id);
        userRepository.delete(user);
    }

    // 로그인 인증
    public String authenticate(String email, String password) {
        User findUser = userRepository.findUserByEmail(email).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "사용자를 찾을 수 없습니다.")
        );

        if(!findUser.getPassword().equals(password)){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "비밀번호가 틀렸습니다.");
        }

        return "로그인 성공";
    }
}
