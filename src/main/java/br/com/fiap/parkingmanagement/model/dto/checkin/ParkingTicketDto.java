package br.com.fiap.parkingmanagement.model.dto.checkin;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ParkingTicketDto(
        @NotBlank(message = "O período em horas deve ser preenchido")
        String period,
        @Valid
        ZoneDto address,
        @Valid
        VehicleDto vehicle,
        @Valid
        PaymentDto payment
) { }