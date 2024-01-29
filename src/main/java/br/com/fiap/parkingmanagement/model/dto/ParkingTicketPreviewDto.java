package br.com.fiap.parkingmanagement.model.dto;

import br.com.fiap.parkingmanagement.model.entity.checkin.ParkingTicket;

public record ParkingTicketPreviewDto(String id, String starDate, String finishDate, String vehiclePlate, String vehicleColor) {

    public ParkingTicketPreviewDto(ParkingTicket ticket) {
        this(ticket.getId(), ticket.getInitialDate(), ticket.getFinalDate(), ticket.getVehicle().getPlate(), "");
    }
}
