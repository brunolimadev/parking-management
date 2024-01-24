package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.entity.*;
import br.com.fiap.parkingmanagement.model.entity.checkin.*;
import br.com.fiap.parkingmanagement.model.entity.checkin.Vehicle;
import br.com.fiap.parkingmanagement.model.entity.checkin.Zone;
import br.com.fiap.parkingmanagement.repository.CheckInRepository;
import br.com.fiap.parkingmanagement.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public void save (ParkingTicketDto parkingTicketDto, User user) {
        ParkingTicket response = this.checkInRepository.save(assembleParkingTicketEntity(parkingTicketDto));
        System.out.println(response.toString());
    }

    private ParkingTicket assembleParkingTicketEntity(ParkingTicketDto parkingTicketDto) {
        return new ParkingTicket(
                parkingTicketDto.period(),
                LocalDateTime.now().toString(),
                LocalDateTime.now().plusHours(2L).toString(),
                new Zone(parkingTicketDto.address().id(), parkingTicketDto.address().local(), "70.00"),
                new Vehicle(parkingTicketDto.vehicle().type().name(), parkingTicketDto.vehicle().plate()),
                new Payment(
                        parkingTicketDto.payment().type(),
                        new Card(parkingTicketDto.payment().card().type(), parkingTicketDto.payment().card().number(), parkingTicketDto.payment().card().verificationCode()),
                        "100")
                );
    }
}