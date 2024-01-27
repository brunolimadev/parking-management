package br.com.fiap.parkingmanagement.service;

import java.time.LocalDateTime;

public interface HolidayService {
    boolean isHoliday(LocalDateTime localDateTime);
}