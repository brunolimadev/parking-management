package br.com.fiap.parkingmanagement.controller;


import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import br.com.fiap.parkingmanagement.service.ParkingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/parking-ticket")
public class ParkingTicketController {

    @Autowired
    private ParkingTicketService parkingTicketService;


    @GetMapping
    public ResponseEntity<List<ParkingTicket>> getParkingTicketByUser(){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.parkingTicketService.getParkingTicketByUserId(user.getId());
    }

    @GetMapping("/{ticket_id}/details")
    public ResponseEntity<TicketDetailDto> getParkingTicketDetail(@PathVariable("ticket_id") String id) {
        return this.parkingTicketService.getParkingTicketDetailByTicketId(id);
    }

}
