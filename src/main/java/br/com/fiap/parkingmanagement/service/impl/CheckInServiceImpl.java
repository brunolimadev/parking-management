package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.CheckInDto;
import br.com.fiap.parkingmanagement.model.entity.CheckIn;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.repository.CheckInRepository;
import br.com.fiap.parkingmanagement.service.CheckInService;
import org.springframework.beans.factory.annotation.Autowired;

public class CheckInServiceImpl implements CheckInService {
    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public void save(CheckInDto checkInDto, User user) {
        this.checkInRepository.save(new CheckIn());
    }
}