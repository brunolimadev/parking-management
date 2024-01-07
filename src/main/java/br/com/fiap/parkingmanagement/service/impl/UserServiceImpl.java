package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.enumerator.UserRoleEnum;
import br.com.fiap.parkingmanagement.model.dto.UserDto;
import br.com.fiap.parkingmanagement.model.entity.User;
import br.com.fiap.parkingmanagement.repository.UserRepository;
import br.com.fiap.parkingmanagement.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     * Método responsável por criar um usuário
     *
     * @param userDto
     */
    @Override
    public void create(UserDto userDto) {

        Optional<UserDetails> userFounded = this.userRepository.findByEmail(userDto.email());

        if (userFounded.isPresent()) {
            throw new RuntimeException("Erro ao criar o usuário! Por favor, tente novamente.");
        }

        String encrypedPassoword = this.passwordEncoder.encode(userDto.password());

        User user = this.convertToEntity(userDto);

        user.setPassword(encrypedPassoword);

        this.userRepository.save(user);
    }

    /**
     * Método responsável por converter um UserDto para um User
     *
     * @param userDto
     * @return
     */
    private User convertToEntity(UserDto userDto) {
        User user = new User();
        user.setActive(true);
        user.setName(userDto.name());
        user.setCreatedAt(LocalDateTime.now().atOffset(ZoneOffset.of("-03:00")).toLocalDateTime());
        user.setEmail(userDto.email());
        user.setPassword(userDto.password());
        user.setRole(userDto.role() != null ? userDto.role() : UserRoleEnum.ROLE_USER);

        return user;
    }
}
