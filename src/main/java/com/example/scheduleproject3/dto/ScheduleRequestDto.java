package com.example.scheduleproject3.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class ScheduleRequestDto {

    private final String username;
    private final String title;
    private final String contents;

}
