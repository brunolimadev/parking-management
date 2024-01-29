package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ParkingTicketService {
    ResponseEntity<TicketDetailDto> getParkingTicketDetailByTicketId(String id, String userId);

    Page<ParkingTicket> getParkingTicketByUserId(String userId, Pageable pageable);
}
