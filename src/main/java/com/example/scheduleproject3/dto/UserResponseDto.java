package com.example.scheduleproject3.dto;

import com.example.scheduleproject3.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserResponseDto {

    private final String email;
    private final String username;

    public static UserResponseDto toDto(User user) {
        return new UserResponseDto(user.getEmail(), user.getUsername());
    }
}
