package com.example.scheduleproject3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SignUpResponseDto {

    private final Long id;
    private final String username;
    private final String email;

}