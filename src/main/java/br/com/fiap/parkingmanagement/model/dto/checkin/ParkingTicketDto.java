package br.com.fiap.parkingmanagement.model.dto.checkin;

public record ParkingTicketDto(
        String period,
        ZoneDto address,
        VehicleDto vehicle,
        PaymentDto payment
) { }