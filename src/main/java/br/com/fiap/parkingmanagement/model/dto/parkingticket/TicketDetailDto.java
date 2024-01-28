package br.com.fiap.parkingmanagement.model.dto.parkingticket;

import java.time.LocalDateTime;

public record TicketDetailDto(String local, String startDate, String finishDate, String paymentType, String vehiclePlate) {
}
