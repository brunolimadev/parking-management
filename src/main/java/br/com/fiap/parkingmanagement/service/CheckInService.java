package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.checkin.ParkingTicketDto;
import br.com.fiap.parkingmanagement.model.entity.User;

public interface CheckInService {
    void save(ParkingTicketDto parkingTicketDto, User user);
}