package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CheckInRepository extends MongoRepository<ParkingTicket, String> {
    Page<ParkingTicket> findByUserId(String userId, Pageable pageable);

    ParkingTicket findByIdAndUserId(String id, String userId);
}