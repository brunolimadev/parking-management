package br.com.fiap.parkingmanagement.repository;

import br.com.fiap.parkingmanagement.model.entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    public Optional<UserDetails> findByEmail(String email);
}
