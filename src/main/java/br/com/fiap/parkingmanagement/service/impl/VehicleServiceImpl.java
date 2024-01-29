package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.controller.exception.VehicleException;
import br.com.fiap.parkingmanagement.enumerator.VehicleTypeEnum;
import br.com.fiap.parkingmanagement.model.dto.VehicleDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.model.entity.Vehicle;
import br.com.fiap.parkingmanagement.repository.UserRepository;
import br.com.fiap.parkingmanagement.repository.VehicleRepository;
import br.com.fiap.parkingmanagement.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    /**
     * Método responsável por criar um veículo
     *
     * @param vehicle
     * @param user
     */
    @Override
    public void save(VehicleDto vehicle, User user) {
        vehicleIsAlreadExists(vehicle, user);

        Vehicle vehicleEntity = this.convertToEntity(vehicle, user);

        this.vehicleRepository.save(vehicleEntity);
    }


    /**
     * Método responsável por atualizar um veículo
     *
     * @param vehicle
     * @param user
     */
    @Override
    public VehicleDto update(VehicleDto vehicle, User user) {

        Vehicle foundedVehicle = this.vehicleRepository.findByPlateAndUserId(vehicle.plate(), user.getId())
                .orElseThrow(() -> new VehicleException("Veículo não encontrado!", "Por favor, tente novamente com outro veículo."));

        foundedVehicle.setName(vehicle.name());
        foundedVehicle.setModel(vehicle.model());
        foundedVehicle.setType(VehicleTypeEnum.valueOf(vehicle.type().name()));
        foundedVehicle.setUpdatedAt(LocalDateTime.now().atOffset(ZoneOffset.of("-03:00")).toLocalDateTime());

        Vehicle updatedVehicle = this.vehicleRepository.save(foundedVehicle);

        return convertToDto(updatedVehicle);
    }

    /**
     * Método responsável por deletar um veículo
     *
     * @param id
     * @param user
     */
    @Override
    public void delete(String id, User user) {
        this.vehicleRepository.deleteByIdAndUserId(id, user.getId());
    }

    /**
     * Método responsável por buscar um veículo pelo id
     *
     * @param id
     * @param user
     * @return
     */
    @Override
    public VehicleDto findById(String id, User user) {
        return this.vehicleRepository.findByIdAndUserId(id, user.getId())
                .map(this::convertToDto)
                .orElseThrow(() -> new VehicleException("Veículo não encontrado!", "Por favor, tente novamente com outro veículo."));
    }

    /**
     * Método responsável por buscar todos os veículos
     *
     * @param user
     * @return
     */
    @Override
    public List<VehicleDto> findAll(User user) {
        return this.vehicleRepository.findAllByUserId(user.getId())
                .stream()
                .map(this::convertToDto)
                .toList();
    }


    /**
     * Método responsável por converter um VehicleDto para um Vehicle
     *
     * @param vehicleDto
     * @param user
     * @return
     */
    private Vehicle convertToEntity(VehicleDto vehicleDto, User user) {
        Vehicle vehicle = new Vehicle();
        vehicle.setName(vehicleDto.name());
        vehicle.setPlate(vehicleDto.plate());
        vehicle.setModel(vehicleDto.model());
        vehicle.setType(vehicleDto.type());
        vehicle.setCreatedAt(LocalDateTime.now().atOffset(ZoneOffset.of("-03:00")).toLocalDateTime());
        vehicle.setUser(user);
        return vehicle;
    }

    private VehicleDto convertToDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto(
                vehicle.getName(),
                vehicle.getModel(),
                vehicle.getType(),
                vehicle.getPlate(),
                vehicle.getCreatedAt(),
                vehicle.getUpdatedAt()
        );

        return vehicleDto;
    }

    /**
     * Método responsável por verificar se o veículo já existe
     *
     * @param vehicle
     * @param user
     */
    private void vehicleIsAlreadExists(VehicleDto vehicle, User user) {
        Optional<Vehicle> foundedVehicle = this.vehicleRepository.findByPlateAndUserId(vehicle.plate(), user.getId());

        if (foundedVehicle.isPresent()) {
            throw new VehicleException("Veículo já cadastrado!", "Por favor, tente novamente com outro veículo.");
        }

    }

}
