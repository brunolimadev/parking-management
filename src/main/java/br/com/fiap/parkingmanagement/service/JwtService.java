package br.com.fiap.parkingmanagement.service;

import br.com.fiap.parkingmanagement.model.entity.User;

public interface JwtService {
    public String generateToken(User user) throws Exception;

    public String validateToken(String token);
}
