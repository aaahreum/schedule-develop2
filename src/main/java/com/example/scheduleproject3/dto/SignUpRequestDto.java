package com.example.scheduleproject3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpRequestDto {

    private final String email;
    private final String password;
    private final String username;

}
