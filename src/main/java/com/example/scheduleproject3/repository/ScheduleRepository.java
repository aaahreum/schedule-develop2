package com.example.scheduleproject3.repository;

import com.example.scheduleproject3.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScheduleRepository extends JpaRepository<Schedule, Long> {
}
