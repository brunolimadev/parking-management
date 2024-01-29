package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ParkingTicketService {

    void save(ParkingTicketDto parkingTicketDto, User user);

    Page<ParkingTicket> getParkingTicketByUserId(String userId, Pageable pageable);

    ResponseEntity<TicketDetailDto> getParkingTicketDetailByTicketId(String id, String userId);
}
