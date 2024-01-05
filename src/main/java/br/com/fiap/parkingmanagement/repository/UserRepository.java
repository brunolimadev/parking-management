package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.dto.UserDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    public Optional<User> findByEmail(String email);
}
