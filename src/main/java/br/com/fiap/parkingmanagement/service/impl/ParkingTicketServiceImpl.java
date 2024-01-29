package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.parkingticket.TicketDetailDto;
import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import br.com.fiap.parkingmanagement.repository.CheckInRepository;
import br.com.fiap.parkingmanagement.service.ParkingTicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ParkingTicketServiceImpl implements ParkingTicketService {

    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public ResponseEntity<TicketDetailDto> getParkingTicketDetailByTicketId(String id, String userId) {
        ParkingTicket checking = this.checkInRepository.findByIdAndUserId(id, userId);

        if (checking == null) {
            throw new RuntimeException("Cartão de estacionamento não encontrado!");
        }

        return ResponseEntity.status(HttpStatus.OK).body(
                new TicketDetailDto(
                        checking.getZone().getLocal(),
                        checking.getInitialDate(),
                        checking.getFinalDate(),
                        checking.getPayment().getType(),
                        checking.getVehicle().getPlate()
                )
        );
    }

    @Override
    public Page<ParkingTicket> getParkingTicketByUserId(String userId, Pageable pageable) {
        return this.checkInRepository.findByUserId(userId, pageable);
    }
}
