package br.com.fiap.parkingmanagement.model.dto.checkin;

import jakarta.validation.constraints.NotNull;

public record ZoneDto(
        @NotNull(message = "O id da zona não pode ser nulo.")
        String id,
        @NotNull(message = "O local não pode ser nulo.")
        String local
) { }