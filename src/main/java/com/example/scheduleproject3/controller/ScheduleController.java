package com.example.scheduleproject3.controller;

import com.example.scheduleproject3.dto.ScheduleRequestDto;
import com.example.scheduleproject3.dto.ScheduleResponseDto;
import com.example.scheduleproject3.entity.Schedule;
import com.example.scheduleproject3.service.ScheduleService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;

    /**
     * 일정 생성 API
     * @param scheduleRequestDto
     * @return
     */
    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createSchedule(@RequestBody ScheduleRequestDto scheduleRequestDto){
        ScheduleResponseDto scheduleResponseDto = scheduleService.createSchedule(scheduleRequestDto.getUsername(),scheduleRequestDto.getTitle(),scheduleRequestDto.getContents());

        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleResponseDto>> findAllSchedules(){
        List<ScheduleResponseDto> scheduleResponseDtoList = scheduleService.findAllSchedules();
        return new ResponseEntity<>(scheduleResponseDtoList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findScheduleById(@PathVariable Long id){
        ScheduleResponseDto scheduleResponseDto = scheduleService.findScheduleById(id);
        return new ResponseEntity<>(scheduleResponseDto, HttpStatus.OK);
    }

}
