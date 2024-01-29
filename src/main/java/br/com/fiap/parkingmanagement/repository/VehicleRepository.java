package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.Vehicle;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VehicleRepository extends MongoRepository<Vehicle, String> {

    public Optional<Vehicle> findByPlateAndUserId(String plate, String userId);

    public void deleteByIdAndUserId(String id, String userId);

    public Optional<Vehicle> findByIdAndUserId(String id, String userId);

    public List<Vehicle> findAllByUserId(String userId);
}
