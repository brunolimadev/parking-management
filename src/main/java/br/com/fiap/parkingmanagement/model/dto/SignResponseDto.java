package br.com.fiap.parkingmanagement.model.dto;

public record SignResponseDto(
        boolean isAuthenticated,
        String name
) {
}
