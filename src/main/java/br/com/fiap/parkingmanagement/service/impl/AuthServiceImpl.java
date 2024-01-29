package br.com.fiap.parkingmanagement.service.impl;

import br.com.fiap.parkingmanagement.repository.UserRepository;
import br.com.fiap.parkingmanagement.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Método responsável por obter um usuário pelo email
     *
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        return this.userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Erro ao obter usuário."));

    }
}
