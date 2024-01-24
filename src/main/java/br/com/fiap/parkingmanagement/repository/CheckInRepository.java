package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckInRepository extends MongoRepository<ParkingTicket, String> {}