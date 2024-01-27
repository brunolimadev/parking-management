package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.ZoneDto;
import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.entity.*;
import br.com.fiap.parkingmanagement.model.entity.checkin.*;
import br.com.fiap.parkingmanagement.model.entity.checkin.Vehicle;
import br.com.fiap.parkingmanagement.model.entity.checkin.Zone;
import br.com.fiap.parkingmanagement.repository.CheckInRepository;
import br.com.fiap.parkingmanagement.service.CheckInService;
import br.com.fiap.parkingmanagement.service.HolidayService;
import br.com.fiap.parkingmanagement.service.ZoneService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    @Autowired
    private ZoneService zoneService;

    @Autowired
    private HolidayService holidayService;

    @Override
    public void save (ParkingTicketDto parkingTicketDto, User user) {
        ParkingTicket response = this.checkInRepository.save(assembleParkingTicketEntity(parkingTicketDto));
        System.out.println(new Gson().toJson(response));
    }

    private ParkingTicket assembleParkingTicketEntity(ParkingTicketDto parkingTicketDto) {
        return new ParkingTicket(
                parkingTicketDto.period(),
                LocalDateTime.now().toString(),
                LocalDateTime.now().plusHours(Long.parseLong(parkingTicketDto.period())).toString(),
                new Zone(parkingTicketDto.address().id(), parkingTicketDto.address().local(), String.valueOf(getPriceZonePerHour(parkingTicketDto))),
                new Vehicle(parkingTicketDto.vehicle().type().name(), parkingTicketDto.vehicle().plate()),
                new Payment(
                        parkingTicketDto.payment().type(),
                        new Card(parkingTicketDto.payment().card().type(), parkingTicketDto.payment().card().number(), parkingTicketDto.payment().card().verificationCode()),
                        String.valueOf(calculatePaymentValue(parkingTicketDto)))
                );
    }

    private Double getPriceZonePerHour(ParkingTicketDto parkingTicketDto) {
        List<ZoneDto> zoneDtoList = this.zoneService.findByLocal(Optional.ofNullable(parkingTicketDto.address().local()), Optional.<String>empty());

        ZoneDto zoneDto = zoneDtoList
                .stream()
                .filter(zone -> zone.id() == Long.parseLong(parkingTicketDto.address().id()))
                .findFirst().orElseThrow();

        DayOfWeek day = LocalDateTime.now().getDayOfWeek();

        if (day == DayOfWeek.SATURDAY) {
            return zoneDto.r1SaturdayValuePerHour();
        }
        if (day == DayOfWeek.SUNDAY) {
            return zoneDto.r1SundayValuePerHour();
        }
        if (this.holidayService.isHoliday(LocalDateTime.now())) {
            return zoneDto.r1HolidayValuePerHour();
        }

        return zoneDto.r1WeekValuePerHour();
    }

    private Double calculatePaymentValue(ParkingTicketDto parkingTicketDto) {
        return Integer.parseInt(parkingTicketDto.period()) * getPriceZonePerHour(parkingTicketDto);
    }
}