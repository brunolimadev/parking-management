package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CheckInRepository extends MongoRepository<ParkingTicket, String> {
    List<ParkingTicket> findByUserId(String userId);
}