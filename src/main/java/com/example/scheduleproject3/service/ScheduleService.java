package com.example.scheduleproject3.service;

import com.example.scheduleproject3.dto.ScheduleResponseDto;
import com.example.scheduleproject3.dto.UserResponseDto;
import com.example.scheduleproject3.entity.Schedule;
import com.example.scheduleproject3.entity.User;
import com.example.scheduleproject3.repository.ScheduleRepository;
import com.example.scheduleproject3.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    // 일정 생성
    public ScheduleResponseDto createSchedule(String username, String title, String contents) {

        // username을 이용해 User 객체 조회
        User findUser = userRepository.findUserByUsernameOrElseThrow(username);

        Schedule schedule = new Schedule(title,contents, findUser);

        scheduleRepository.save(schedule);

        return new ScheduleResponseDto(
                schedule.getId(),
                schedule.getUser().getUsername(),
                schedule.getTitle(),
                schedule.getContents(),
                schedule.getCreatedAt(),
                schedule.getModifiedAt()
        );
    }

    // 전체 일정 조회
    public List<ScheduleResponseDto> findAllSchedules() {
        List<Schedule> scheduleList = scheduleRepository.findAll();
        return scheduleList.stream().map(ScheduleResponseDto::toDto).toList();
    }

    // 일정 단건 조회
    public ScheduleResponseDto findScheduleById(Long id) {
        Optional<Schedule> optionalSchedule = scheduleRepository.findById(id);

        if(optionalSchedule.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID가 존재하지 않습니다.");
        }

        Schedule findSchedule = optionalSchedule.get();
        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getUser().getUsername(),
                findSchedule.getTitle(),
                findSchedule.getContents(),
                findSchedule.getCreatedAt(),
                findSchedule.getModifiedAt()
        );
    }

    // 일정 수정
    public ScheduleResponseDto updateSchedule(Long id, String title, String contents) {
        Schedule findSchedule = scheduleRepository.findByIdOrElseThrow(id);
        findSchedule.updateSchedule(title, contents);
        scheduleRepository.save(findSchedule);

        return new ScheduleResponseDto(
                findSchedule.getId(),
                findSchedule.getUser().getUsername(),
                findSchedule.getTitle(),
                findSchedule.getContents(),
                findSchedule.getCreatedAt(),
                findSchedule.getModifiedAt()
        );
    }

    // 일정 삭제
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        scheduleRepository.delete(schedule);
    }
}
