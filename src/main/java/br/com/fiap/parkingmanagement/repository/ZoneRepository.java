package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.Zone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ZoneRepository extends MongoRepository<Zone, String> {

    Page<Zone> findAll(Pageable pageable);


}
