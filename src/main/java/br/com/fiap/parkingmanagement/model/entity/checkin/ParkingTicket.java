package br.com.fiap.parkingmanagement.model.entity.checkin;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ParkingTicket {
    private String period;
    private String initialDate;
    private String finalDate;
    private Zone zone;
    private Vehicle vehicle;
    private Payment payment;
}