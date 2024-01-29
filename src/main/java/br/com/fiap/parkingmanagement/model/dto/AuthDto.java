package br.com.fiap.parkingmanagement.model.dto;

import jakarta.validation.constraints.Email;

public record AuthDto(
        @Email(message = "Deve ser um email válido.")
        String email,
        String password
) {
}
