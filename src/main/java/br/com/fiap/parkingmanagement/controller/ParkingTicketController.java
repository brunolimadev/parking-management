package br.com.fiap.parkingmanagement.controller;


import br.com.fiap.parkingmanagement.model.dto.ParkingTicketPreviewDto;
import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.service.ParkingTicketService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking-ticket")
public class ParkingTicketController {

    @Autowired
    private ParkingTicketService parkingTicketService;

    @PostMapping("/checking")
    public ResponseEntity<ParkingTicketDto> checking(@Valid @RequestBody ParkingTicketDto parkingTicketDto) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        this.parkingTicketService.save(parkingTicketDto, user);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<ParkingTicketPreviewDto>> getParkingTicketByUser(
            @PageableDefault(size = 10, sort = {"nome"})Pageable pageable){
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.status(HttpStatus.OK)
                .body(this.parkingTicketService.getParkingTicketByUserId(user.getId(), pageable)
                        .map(ParkingTicketPreviewDto::new));
    }

    @GetMapping("/{ticket_id}/details")
    public ResponseEntity<TicketDetailDto> getParkingTicketDetail(@PathVariable("ticket_id") String ticketId) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return this.parkingTicketService.getParkingTicketDetailByTicketId(ticketId, user.getId());
    }

}
