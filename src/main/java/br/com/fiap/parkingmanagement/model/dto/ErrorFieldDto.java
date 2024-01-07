package br.com.fiap.parkingmanagement.model.dto;

public record ErrorFieldDto(
        String field,
        String message
) {
}
