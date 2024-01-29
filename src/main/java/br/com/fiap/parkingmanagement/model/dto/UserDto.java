package br.com.fiap.parkingmanagement.model.dto;

import br.com.fiap.parkingmanagement.enumerator.UserRoleEnum;
import jakarta.validation.constraints.*;

import java.time.LocalDateTime;

public record UserDto(
    String name,
    @Email(message = "Deve ser um email válido.")
    String email,
    @Size(min = 6, max = 12, message = "Senha de ter no mínimo 6 caracteres.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$", message = "Senha deve conter pelo menos uma letra maiúscula, uma minúscula, um número e um caractere especial.")
    String password,
    LocalDateTime createdAt,
    UserRoleEnum role
) {
}
