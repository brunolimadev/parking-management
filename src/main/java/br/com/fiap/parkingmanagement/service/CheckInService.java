package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.CheckInDto;
import br.com.fiap.parkingmanagement.model.entity.User;

public interface CheckInService {
    void save(CheckInDto checkInDto, User user);
}