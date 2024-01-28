package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingTicketService {
    ResponseEntity<TicketDetailDto> getParkingTicketDetailByTicketId(String id);

    ResponseEntity<List<ParkingTicket>> getAllParkingTicket();

    ResponseEntity<List<ParkingTicket>> getParkingTicketByUserId(String userId);
}
