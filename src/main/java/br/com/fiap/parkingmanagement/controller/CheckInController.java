package br.com.fiap.parkingmanagement.controller;

import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.service.CheckInService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkin")
public class CheckInController {
    @Autowired
    private CheckInService checkInService;

    @PostMapping
    public ResponseEntity<ParkingTicketDto> create(@RequestBody ParkingTicketDto parkingTicketDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.checkInService.save(parkingTicketDto, user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}