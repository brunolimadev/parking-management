package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.HolidayDto;
import br.com.fiap.parkingmanagement.service.HolidayService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Stream;

@Service
public class HolidayServiceImpl implements HolidayService {
    @Value("${holiday.url}")
    private String url;

    @Override
    public boolean isHoliday(LocalDateTime localDateTime) {
        RestTemplate template = new RestTemplate();
        HolidayDto[] holidayDtoList = template.getForObject(this.url + "/{year}", HolidayDto[].class, localDateTime.getYear());

        AtomicBoolean result = new AtomicBoolean(false);

        assert holidayDtoList != null;
        Stream.of(holidayDtoList).forEach(holidayDto -> {
            if (Objects.equals(holidayDto.date(), localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")))) {
                result.set(true);
            }
        });

        return result.get();
    }
}