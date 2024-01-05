package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.model.dto.UserDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.repository.UserRepository;
import br.com.fiap.parkingmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(UserDto userDto) {

        Optional<User> userFounded = this.userRepository.findByEmail(userDto.email());

        if(userFounded.isPresent()){
           throw new RuntimeException("Create user error. Please, try again.");
        }

        User user = this.convertToEntity(userDto);

        this.userRepository.save(user);
    }

    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setCreatedAt(LocalDateTime.now());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());

        return user;
    }
}
