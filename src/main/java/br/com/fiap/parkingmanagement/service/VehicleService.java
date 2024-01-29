package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.dto.VehicleDto;
import br.com.fiap.parkingmanagement.model.entity.User;

import java.util.List;

public interface VehicleService {

    public void save(VehicleDto vehicle, User user);

    public VehicleDto update(VehicleDto vehicle, User user);

    public void delete(String id, User user);

    public VehicleDto findById(String id, User user);

    public List<VehicleDto> findAll(User user);

}
